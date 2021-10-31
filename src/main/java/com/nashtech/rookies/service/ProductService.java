package com.nashtech.rookies.service;

import com.nashtech.rookies.dto.ProductDto;

import java.util.Set;

public interface ProductService {
    Set<ProductDto> findAllProduct();

    ProductDto findByIdProduct(String id);
}
