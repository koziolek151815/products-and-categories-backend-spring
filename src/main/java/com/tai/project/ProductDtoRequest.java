package com.tai.project;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoRequest {
    private String name;
    private Double price;
    private Long categoryId;
}
