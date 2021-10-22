package com.nashtech.rookies.dto;

import com.nashtech.rookies.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private String description;
    private float price;
    private List<String> imageUrls;
    private CategoryDto category; //nice work
}
