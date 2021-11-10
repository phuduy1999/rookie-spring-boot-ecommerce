package com.nashtech.rookies.controller;

import com.nashtech.rookies.converter.ProductConverter;
import com.nashtech.rookies.dto.ProductDto;
import com.nashtech.rookies.dto.ResponseDto;
import com.nashtech.rookies.entity.Product;
import com.nashtech.rookies.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor  //annotation trigger autowired final variable
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Object> findAllProduct() {
        Set<ProductDto> productDtoSet = productService.findAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(productDtoSet);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> findByIdProduct(@PathVariable("id") String id) {
        ProductDto productDto = productService.findByIdProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("/count")
    public ResponseEntity<ResponseDto> countProduct() {
        ResponseDto responseDto = productService.countProduct();
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    public ResponseEntity<ResponseDto> saveProduct(@Valid @RequestBody ProductDto productDto) {
        ResponseDto responseDto = productService.saveProduct(productDto);
        return ResponseEntity.ok(responseDto);
    }
}
