package com.nashtech.rookies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String id;

    @NotNull(message = "name is null")
    private String name;

    private String description;

    @NotNull(message = "price is null")
    @DecimalMin(value = "0", message = "price must be not below 0")
    private float price;

    private List<String> imageUrls;

    private CategoryDto category; //nice work
}
