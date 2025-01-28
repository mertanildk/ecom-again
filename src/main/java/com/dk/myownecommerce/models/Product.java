package com.dk.myownecommerce.models;

import com.dk.myownecommerce.core.model.BaseEntity;
import com.dk.myownecommerce.models.enums.OrderStatus;
import com.dk.myownecommerce.models.enums.UserState;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {
    private String name;
    private String description;
    private String brand;
    private String price;
    private Integer stock = 30;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
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


