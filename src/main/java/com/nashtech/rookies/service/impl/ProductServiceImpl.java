package com.nashtech.rookies.service.impl;

import com.nashtech.rookies.constant.ErrorCode;
import com.nashtech.rookies.constant.SuccessCode;
import com.nashtech.rookies.converter.ProductConverter;
import com.nashtech.rookies.dto.ProductDto;
import com.nashtech.rookies.dto.ResponseDto;
import com.nashtech.rookies.entity.Brand;
import com.nashtech.rookies.entity.Product;
import com.nashtech.rookies.exception.IdNotFoundException;
import com.nashtech.rookies.repository.BrandRepository;
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

    private final ProductConverter productConverter;

    private final BrandRepository brandRepository;

    @Override
    public Set<ProductDto> findAllProduct() {
        List<Product> productList = productRepository.findAll();

        Set<ProductDto> productDtoSet = MapperUtil
                .mapListToStream(productList, ProductDto.class)
                .collect(Collectors.toSet());

//        productDtoSet.stream().forEach(productDto -> {
//            List<String> imgUrls = productDto.getImageUrls().stream().map(imgUrl -> {
//                return UriPathUtil.getUriPath(imgUrl);
//            }).collect(Collectors.toList());
//            productDto.setImageUrls(imgUrls);
//        });

        return productDtoSet;
    }

    @Override
    public ProductDto findByIdProduct(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "product with id " + id + " does not exists"
                ));
        ProductDto productDto = MapperUtil.mapOne(product, ProductDto.class);

//        List<String> imgUrls = productDto.getImageUrls().stream().map(imgUrl -> {
//            return UriPathUtil.getUriPath(imgUrl);
//        }).collect(Collectors.toList());
//        productDto.setImageUrls(imgUrls);

        return productDto;
    }

    @Override
    public ResponseDto countProduct() {
        ResponseDto responseDto = new ResponseDto();
        Long quantity = productRepository.count();

        responseDto.setSuccessCode(SuccessCode.SUCCESS_COUNT_PRODUCT);
        responseDto.setData(quantity);
        return responseDto;
    }

    @Override
    public ResponseDto saveProduct(ProductDto productDto) {
        Product product = productConverter.convertToEntity(productDto);

        Brand brand = brandRepository.findById(product.getBrand().getId())
                .orElseThrow(() -> new IdNotFoundException(ErrorCode.ERR_BRAND_ID_NOT_FOUND));


        return null;
    }
}
