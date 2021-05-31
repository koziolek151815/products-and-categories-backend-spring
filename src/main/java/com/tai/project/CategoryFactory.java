package com.tai.project;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryFactory {
    public CategoryResponseDto entityToCategoryResponseDto(CategoryEntity entity) {
        return CategoryResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public CategoryEntity CategoryRequestDtoToEntity(CategoryRequestDto categoryRequestDto) {
        return CategoryEntity.builder()
                .name(categoryRequestDto.getName())
                .build();
    }

    public CategoryEntity updateEntityFromCategoryRequestDto(CategoryEntity categoryEntity, CategoryRequestDto categoryRequestDto) {
        categoryEntity.setName(categoryRequestDto.getName());
        return categoryEntity;
    }
}
