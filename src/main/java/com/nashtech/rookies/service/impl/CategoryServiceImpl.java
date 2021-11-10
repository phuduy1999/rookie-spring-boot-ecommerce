package com.nashtech.rookies.service.impl;

import com.nashtech.rookies.constant.ErrorCode;
import com.nashtech.rookies.constant.SuccessCode;
import com.nashtech.rookies.dto.CategoryDto;
import com.nashtech.rookies.dto.ResponseDto;
import com.nashtech.rookies.entity.Category;
import com.nashtech.rookies.exception.*;
import com.nashtech.rookies.repository.CategoryRepository;
import com.nashtech.rookies.repository.ProductRepository;
import com.nashtech.rookies.service.CategoryService;
import com.nashtech.rookies.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public Set<CategoryDto> findAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();

        Set<CategoryDto> categoryDtoSet = MapperUtil
                .mapListToStream(categoryList, CategoryDto.class)
                .collect(Collectors.toSet());

        return categoryDtoSet;
    }

    @Override
    public CategoryDto findByIdCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "category with id " + id + " does not exists"
                ));
        CategoryDto categoryDto = MapperUtil.mapOne(category, CategoryDto.class);
        return categoryDto;
    }

    @Override
    public void createCategory(CategoryDto categoryDto) {
        Category category = MapperUtil.mapOne(categoryDto, Category.class);
        Optional<Category> categoryOptional = categoryRepository.findCategoryByName(category.getName());
        if (categoryOptional.isPresent()) {
            throw new CategoryNameExistException(ErrorCode.ERR_CATEGORY_NAME_EXIST);
        }

        Category categoryParent = categoryRepository.findByIdAndCategoryIsNull(categoryDto.getParentId());
        category.setCategory(categoryParent);

        try {
            categoryRepository.save(category);
        } catch (Exception e) {
            throw new SaveErrorException(ErrorCode.ERR_SAVE_CATEGORY);
        }
    }

    @Override
    public void updateCategory(CategoryDto categoryDto, Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(ErrorCode.ERR_CATEGORY_ID_NOT_FOUND));

        if (categoryRepository.existsCategoryByIdNotAndName(id, categoryDto.getName())) {
            throw new CategoryNameExistException(ErrorCode.ERR_CATEGORY_NAME_EXIST);
        }
        Category categoryMap = MapperUtil.mapOne(categoryDto, Category.class);
        categoryMap.setId(category.getId());

        try {
            categoryRepository.save(categoryMap);
        } catch (Exception e) {
            throw new UpdateErrorException(ErrorCode.ERR_UPDATE_CATEGORY);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        boolean exists = categoryRepository.existsById(id);
        if (!exists) {
            throw new IdNotFoundException(ErrorCode.ERR_CATEGORY_ID_NOT_FOUND);
        }
        if (productRepository.existsProductByCategoryId(id)) {
            throw new CategoryExistInProductException(ErrorCode.ERR_CATEGORY_EXIST_IN_PRODUCT);
        }
        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteErrorException(ErrorCode.ERR_DELETE_CATEGORY);
        }
    }

    @Override
    public ResponseDto retrieveParentCategory() {
        List<Category> parentCategory = categoryRepository.findByCategoryIsNull();
        List<CategoryDto> categoriesDto = MapperUtil.mapListToStream(parentCategory, CategoryDto.class)
                .collect(Collectors.toList());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoriesDto);
        responseDto.setSuccessCode(SuccessCode.SUCCESS_GET_ALL_PARENT_CATEGORY);
        return responseDto;
    }

    @Override
    public ResponseDto retrieveSubCategory(Long parentId) {
        List<Category> subCategory = categoryRepository.findSubCategoryByParentCategoryId(parentId);
        List<CategoryDto> categoriesDto = MapperUtil.mapListToStream(subCategory, CategoryDto.class)
                .collect(Collectors.toList());
        categoriesDto.stream().forEach(categoryDto -> {
            categoryDto.setParentId(parentId);
        });
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(categoriesDto);
        responseDto.setSuccessCode(SuccessCode.SUCCESS_GET_SUB_CATEGORY);
        return responseDto;
    }

}
