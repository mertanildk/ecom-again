package com.dk.myownecommerce.models;

import com.dk.myownecommerce.core.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineItem extends BaseEntity {
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
