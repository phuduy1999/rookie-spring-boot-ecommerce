package com.nashtech.rookies.service;

import com.nashtech.rookies.dto.CategoryDto;

import java.util.Set;

public interface CategoryService {
    public Set<CategoryDto> getAll();

    public CategoryDto getOneById(Long id);

    public void addNew(CategoryDto categoryDto);
}
