package com.nashtech.rookies.converter;

import com.nashtech.rookies.constant.ErrorCode;
import com.nashtech.rookies.dto.ProductDto;
import com.nashtech.rookies.entity.Brand;
import com.nashtech.rookies.entity.Category;
import com.nashtech.rookies.entity.Product;
import com.nashtech.rookies.exception.SaveErrorException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private ModelMapper modelMapper;

    public Product convertToEntity(ProductDto productDto) {
        try {
            Product product = modelMapper.map(productDto, Product.class);
            product.setBrand(new Brand());
            product.setCategory(new Category());
            product.getBrand().setId(productDto.getBrandId());
            product.getCategory().setId(productDto.getCategoryId());
            return product;
        } catch (Exception e) {
            throw new SaveErrorException(ErrorCode.ERR_SAVE_PRODUCT);
        }

    }

    public ProductDto convertToDto(Product product) {
        try {
            ProductDto productDto = modelMapper.map(product, ProductDto.class);
            productDto.setCategoryId(product.getCategory().getCategory().getId());
            return productDto;
        } catch (Exception e) {
            throw new SaveErrorException(ErrorCode.ERR_SAVE_PRODUCT);
        }
    }

}
