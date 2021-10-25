package com.nashtech.rookies.service;

import com.nashtech.rookies.dto.CategoryDto;

import java.util.Set;

public interface CategoryService {
    public Set<CategoryDto> findAllCategory();

    public CategoryDto findByIdCategory(Long id);

    public void createCategory(CategoryDto categoryDto);

    public void updateCategory(CategoryDto categoryDto, Long id);

    public void deleteCategory(Long id);
}
