package com.dk.myownecommerce.models;

import com.dk.myownecommerce.core.model.BaseEntity;
import com.dk.myownecommerce.models.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends BaseEntity {
    private LocalDateTime ordered;
    private LocalDateTime shipped;
    private Double total;

    @OneToOne
    private Address shipTo;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    private Account account;

    @OneToMany
    private List<LineItem> lineItems;

    @OneToMany
    private List<Payment> payments;
}
