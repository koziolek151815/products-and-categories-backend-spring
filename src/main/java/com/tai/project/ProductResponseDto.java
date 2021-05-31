package com.tai.project;

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
