package com.tai.project.products.dto;

import com.tai.project.categories.dto.CategoryResponseDto;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor

public class ProductResponseDto {
    private Long id;
    private String name;
    private Double price;
    private CategoryResponseDto category;
}
