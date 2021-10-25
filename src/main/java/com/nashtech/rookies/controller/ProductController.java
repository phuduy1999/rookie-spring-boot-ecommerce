package com.nashtech.rookies.controller;

import com.nashtech.rookies.dto.CategoryDto;
import com.nashtech.rookies.dto.ProductDto;
import com.nashtech.rookies.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Set;

@RequiredArgsConstructor  //annotation trigger autowired final variable
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
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

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestPart("product") @Valid ProductDto productDto,
                              @RequestPart("file") MultipartFile file){

    }
}
