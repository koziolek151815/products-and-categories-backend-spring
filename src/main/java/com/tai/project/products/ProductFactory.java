package com.tai.project.products;

import com.tai.project.categories.CategoryEntity;
import com.tai.project.categories.dto.CategoryResponseDto;
import com.tai.project.products.dto.ProductRequestDto;
import com.tai.project.products.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductFactory {
    public ProductResponseDto entityToProductResponseDto(ProductEntity productEntity) {
        return ProductResponseDto.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .category(CategoryResponseDto.builder()
                        .id(productEntity.getCategory().getId())
                        .name(productEntity.getCategory().getName())
                        .build())
                .build();
    }

    public ProductEntity productRequestDtoToEntity(ProductRequestDto productRequestDto, CategoryEntity categoryEntity) {
        return ProductEntity.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .category(categoryEntity)
                .build();
    }

    public ProductEntity updateEntityFromProductRequestDto(ProductEntity productEntity, ProductRequestDto productRequestDto, CategoryEntity categoryEntity) {
        productEntity.setName(productRequestDto.getName());
        productEntity.setPrice(productRequestDto.getPrice());
        productEntity.setCategory(categoryEntity);
        return productEntity;
    }
}
