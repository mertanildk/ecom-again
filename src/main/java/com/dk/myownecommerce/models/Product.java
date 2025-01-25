package com.dk.myownecommerce.models;

import com.dk.myownecommerce.core.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {
    private String name;
    private String description;
    private String brand;
    private String price;
    private Integer stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String price, String brand, String description, String name, Category category) {
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.name = name;
        this.stock = 30;
        this.category = category;
    }

}
