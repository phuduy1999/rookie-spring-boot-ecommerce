package com.nashtech.rookies.service;

import com.nashtech.rookies.dto.CategoryDto;

import java.util.Set;

public interface CategoryService {
    Set<CategoryDto> findAllCategory();

    CategoryDto findByIdCategory(Long id);

    void createCategory(CategoryDto categoryDto);

    void updateCategory(CategoryDto categoryDto, Long id);

    void deleteCategory(Long id);
}
