package com.nashtech.rookies.service;

import com.nashtech.rookies.dto.ProductDto;
import com.nashtech.rookies.dto.ResponseDto;

import java.util.Set;

public interface ProductService {
    Set<ProductDto> findAllProduct();

    ProductDto findByIdProduct(String id);

    ResponseDto countProduct();

    ResponseDto saveProduct(ProductDto productDto);
}
