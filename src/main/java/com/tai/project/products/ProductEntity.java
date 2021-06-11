package com.tai.project.products;

import com.tai.project.categories.CategoryEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;

}
