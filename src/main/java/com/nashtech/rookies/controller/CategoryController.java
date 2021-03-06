package com.nashtech.rookies.controller;

import com.nashtech.rookies.dto.CategoryDto;
import com.nashtech.rookies.dto.ResponseDto;
import com.nashtech.rookies.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor  //annotation trigger autowired final variable
@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Object> findAllCategory() {
        Set<CategoryDto> categoryDtoSet = categoryService.findAllCategory();
        return ResponseEntity.status(HttpStatus.OK).body(categoryDtoSet);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> findByIdCategory(@PathVariable("id") Long id) {
        CategoryDto categoryDto = categoryService.findByIdCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody @Valid CategoryDto categoryDto) {
        categoryService.createCategory(categoryDto);
    }

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCategory(@RequestBody @Valid CategoryDto categoryDto,
                               @PathVariable("id") Long id) {
        categoryService.updateCategory(categoryDto, id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("/parent")
    public ResponseEntity<ResponseDto> retrieveParentCategory() {
        return ResponseEntity.ok(categoryService.retrieveParentCategory());
    }

    @GetMapping("/sub/{parentId}")
    public ResponseEntity<ResponseDto> retrieveSubCategory(@PathVariable("parentId") Long parentId) {
        return ResponseEntity.ok(categoryService.retrieveSubCategory(parentId));
    }

}



