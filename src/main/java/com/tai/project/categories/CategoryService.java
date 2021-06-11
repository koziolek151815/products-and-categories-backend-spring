package com.tai.project.categories;

import com.tai.project.categories.dto.CategoryRequestDto;
import com.tai.project.categories.dto.CategoryResponseDto;
import com.tai.project.products.ProductFactory;
import com.tai.project.products.ProductRepository;
import com.tai.project.products.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CategoryFactory categoryFactory;
    private final ProductFactory productFactory;

    public List<CategoryResponseDto> getAllCategories(){
        return categoryRepository.findAll()
                .stream()
                .map(categoryFactory::entityToCategoryResponseDto)
                .collect(Collectors.toList());
    }

    public CategoryResponseDto getCategoryById(Long categoryId){
        return categoryFactory.entityToCategoryResponseDto(categoryRepository
                .findById(categoryId).orElseThrow(() -> new RuntimeException("Not found such category")));
    }

    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto){
        CategoryEntity categoryEntity= categoryRepository.save(categoryFactory.CategoryRequestDtoToEntity(categoryRequestDto));
        return categoryFactory.entityToCategoryResponseDto(categoryEntity);
    }

    public CategoryResponseDto updateCategory(CategoryRequestDto categoryRequestDto, Long categoryId){
        CategoryEntity categoryToUpdate = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Not found such category"));
        return categoryFactory.entityToCategoryResponseDto(categoryRepository
                .save(categoryFactory.updateEntityFromCategoryRequestDto(categoryToUpdate, categoryRequestDto)));
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.delete(categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Not found such category")));
    }
    public List<ProductResponseDto> getAllProductsForCategory(Long categoryId){
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Not found such category"));
        return productRepository.findAllByCategory(categoryEntity)
                .stream()
                .map(productFactory::entityToProductResponseDto)
                .collect(Collectors.toList());
    }
}
