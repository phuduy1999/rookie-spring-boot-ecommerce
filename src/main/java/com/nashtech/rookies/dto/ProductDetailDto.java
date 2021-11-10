package com.nashtech.rookies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetailDto {
    private Long id;

    private Long productId;

    @NotBlank
    private String color;

    @NotNull
    private Integer quantity;

    @NotNull
    private Long price;

    private List<RateDto> reviews;

}
