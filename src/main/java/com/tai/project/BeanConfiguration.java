package com.tai.project;

import com.tai.project.categories.CategoryFactory;
import com.tai.project.products.ProductFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CategoryFactory categoryFactory() {
        return new CategoryFactory();
    }

    @Bean
    public ProductFactory userFactory() {
        return new ProductFactory();
    }
}
