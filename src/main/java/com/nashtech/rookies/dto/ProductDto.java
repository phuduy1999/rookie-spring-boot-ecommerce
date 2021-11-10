package com.nashtech.rookies.dto;

import com.nashtech.rookies.entity.Brand;
import com.nashtech.rookies.entity.Category;
import com.nashtech.rookies.entity.ProductDetail;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long id;

    @NotBlank
    private String name;

    private String description;

    private String model;

    private String size;

    private Float weight;

    private String material;

    private short warranty;

    private String imageUrl;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @NotNull
    private Long categoryId;
    private CategoryDto category;

    @NotNull
    private Long brandId;
    private BrandDto brand;

    @Valid
    @NotEmpty
    private List<ProductDetailDto> productDetails;
}
