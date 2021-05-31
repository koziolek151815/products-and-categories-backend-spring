package com.tai.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductFactory productFactory;
    private final CategoryRepository categoryRepository;

    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productFactory::entityToProductResponseDto)
                .collect(Collectors.toList());
    }

    public ProductResponseDto getProductById(Long productId) {
        return productFactory.entityToProductResponseDto(productRepository
                .findById(productId).orElseThrow(() -> new RuntimeException("Not found such product")));
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        CategoryEntity categoryEntity = categoryRepository.findById(productRequestDto.getCategoryId()).orElseThrow(() -> new RuntimeException("Not found such category"));
        ProductEntity productEntity = productRepository.save(productFactory.productRequestDtoToEntity(productRequestDto, categoryEntity));
        return productFactory.entityToProductResponseDto(productEntity);
    }

    public ProductResponseDto updateProduct(ProductRequestDto productRequestDto, Long productId) {
        ProductEntity productToUpdate = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not found such product"));
        CategoryEntity categoryEntity = categoryRepository.findById(productRequestDto.getCategoryId()).orElseThrow(() -> new RuntimeException("Not found such category"));

        return productFactory.entityToProductResponseDto(productRepository
                .save(productFactory.updateEntityFromProductRequestDto(productToUpdate, productRequestDto, categoryEntity)));
    }

    public void deleteProduct(Long productId) {
        productRepository.delete(productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Not found such product")));
    }
}
