package com.nashtech.rookies.service.impl;

import com.nashtech.rookies.dto.CategoryDto;
import com.nashtech.rookies.entity.Category;
import com.nashtech.rookies.exception.ForeignKeyException;
import com.nashtech.rookies.exception.NotFoundException;
import com.nashtech.rookies.exception.UniqueConstraintException;
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
            throw new UniqueConstraintException("name taken");
        }
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(CategoryDto categoryDto, Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "category with id " + id + " does not exists"
                ));
        if (categoryRepository.existsCategoryByIdNotAndName(id, categoryDto.getName())) {
            throw new UniqueConstraintException("name taken");
        }
        Category categoryMap = MapperUtil.mapOne(categoryDto, Category.class);
        categoryMap.setId(category.getId());
        categoryRepository.save(categoryMap);
    }

    @Override
    public void deleteCategory(Long id) {
        boolean exists = categoryRepository.existsById(id);
        if (!exists) {
            throw new NotFoundException("category with id " + id + " does not exists");
        }
        if (productRepository.existsProductByCategoryId(id)) {
            throw new ForeignKeyException("category with id " + id + " has products");
        }
        categoryRepository.deleteById(id);
    }

}
