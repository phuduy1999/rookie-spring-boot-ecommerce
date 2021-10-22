package com.nashtech.rookies.service.impl;

import com.nashtech.rookies.dto.CategoryDto;
import com.nashtech.rookies.dto.ProductDto;
import com.nashtech.rookies.entity.Category;
import com.nashtech.rookies.entity.Product;
import com.nashtech.rookies.repository.ProductRepository;
import com.nashtech.rookies.service.ProductService;
import com.nashtech.rookies.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Set<ProductDto> getAll() {
        List<Product> productList = productRepository.findAll();

        Set<ProductDto> productDtoSet = MapperUtil
                .mapListToStream(productList, ProductDto.class)
                .collect(Collectors.toSet());

        return productDtoSet;
    }

    @Override
    public ProductDto getOneById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "product with id " + id + " does not exists"
                ));
        ProductDto productDto = MapperUtil.mapOne(product, ProductDto.class);
        return productDto;
    }
}
