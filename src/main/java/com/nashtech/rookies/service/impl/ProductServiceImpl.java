package com.nashtech.rookies.service.impl;

import com.nashtech.rookies.dto.ProductDto;
import com.nashtech.rookies.entity.Product;
import com.nashtech.rookies.repository.ProductRepository;
import com.nashtech.rookies.service.ProductService;
import com.nashtech.rookies.util.MapperUtil;
import com.nashtech.rookies.util.UriPathUtil;
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
    public Set<ProductDto> findAllProduct() {
        List<Product> productList = productRepository.findAll();

        Set<ProductDto> productDtoSet = MapperUtil
                .mapListToStream(productList, ProductDto.class)
                .collect(Collectors.toSet());

        productDtoSet.stream().forEach(productDto -> {
            List<String> imgUrls = productDto.getImageUrls().stream().map(imgUrl -> {
                return UriPathUtil.getUriPath(imgUrl);
            }).collect(Collectors.toList());
            productDto.setImageUrls(imgUrls);
        });

        return productDtoSet;
    }

    @Override
    public ProductDto findByIdProduct(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "product with id " + id + " does not exists"
                ));
        ProductDto productDto = MapperUtil.mapOne(product, ProductDto.class);

        List<String> imgUrls = productDto.getImageUrls().stream().map(imgUrl -> {
            return UriPathUtil.getUriPath(imgUrl);
        }).collect(Collectors.toList());
        productDto.setImageUrls(imgUrls);

        return productDto;
    }
}
