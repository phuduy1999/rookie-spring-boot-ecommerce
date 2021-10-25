package com.nashtech.rookies.service;

import com.nashtech.rookies.dto.ProductDto;

import java.util.Set;

public interface ProductService {
    public Set<ProductDto> findAllProduct();

    public ProductDto findByIdProduct(String id);
}
