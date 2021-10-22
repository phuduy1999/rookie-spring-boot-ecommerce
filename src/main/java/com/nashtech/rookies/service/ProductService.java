package com.nashtech.rookies.service;

import com.nashtech.rookies.dto.ProductDto;

import java.util.Set;

public interface ProductService {
    public Set<ProductDto> getAll();

    public ProductDto getOneById(String id);
}
