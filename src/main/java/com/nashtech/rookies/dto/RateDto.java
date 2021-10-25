package com.nashtech.rookies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateDto {
    private Long id;
    private int rating;
    private String rateReview;
    private LocalDate dateCreated;
    private UserDto user;
    private ProductDto product;
}
