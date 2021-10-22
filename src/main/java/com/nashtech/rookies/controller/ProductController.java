package com.nashtech.rookies.controller;

import com.nashtech.rookies.dto.ProductDto;
import com.nashtech.rookies.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RequiredArgsConstructor  //annotation trigger autowired final variable
@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        Set<ProductDto> productDtoSet = productService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(productDtoSet);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getOneById(@PathVariable("id") String id) {
        ProductDto productDto = productService.getOneById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }
}
