package com.nashtech.rookies.service.impl;

import com.nashtech.rookies.dto.CategoryDto;
import com.nashtech.rookies.entity.Category;
import com.nashtech.rookies.exception.DuplicateRecordException;
import com.nashtech.rookies.exception.NullFieldException;
import com.nashtech.rookies.repository.CategoryRepository;
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

    @Override
    public Set<CategoryDto> getAll() {
        List<Category> categoryList = categoryRepository.findAll();

        Set<CategoryDto> categoryDtoSet = MapperUtil
                .mapListToStream(categoryList, CategoryDto.class)
                .collect(Collectors.toSet());

        return categoryDtoSet;
    }

    @Override
    public CategoryDto getOneById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "category with id " + id + " does not exists"
                ));
        CategoryDto categoryDto = MapperUtil.mapOne(category, CategoryDto.class);
        return categoryDto;
    }

    @Override
    public void addNew(CategoryDto categoryDto) {
        Category category = MapperUtil.mapOne(categoryDto, Category.class);
        Optional<Category> categoryOptional = categoryRepository.findCategoryByName(category.getName());
        if (categoryOptional.isPresent()) {
            throw new DuplicateRecordException("name taken");
        }
        categoryRepository.save(category);
    }
}
