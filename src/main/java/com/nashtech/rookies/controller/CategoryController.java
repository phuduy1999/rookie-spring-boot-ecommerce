package com.nashtech.rookies.controller;

import com.nashtech.rookies.dto.CategoryDto;
import com.nashtech.rookies.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RequiredArgsConstructor  //annotation trigger autowired final variable
@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        Set<CategoryDto> categoryDtoSet = categoryService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(categoryDtoSet);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getOneById(@PathVariable("id") Long id){
        CategoryDto categoryDto = categoryService.getOneById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDto);
    }

    @PostMapping
    public ResponseEntity<Object> addNew(@RequestBody @Valid CategoryDto categoryDto){
        categoryService.addNew(categoryDto);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDto);
    }
}
