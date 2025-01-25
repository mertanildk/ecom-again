package com.dk.myownecommerce.models;

import com.dk.myownecommerce.core.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Category extends BaseEntity {
    private String name;
    private String description;


    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Product> products;

    public Category(String name, String description) {
        setId("1");
        this.name = name;
        this.description = description;
    }
}
