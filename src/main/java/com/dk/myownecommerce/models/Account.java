package com.dk.myownecommerce.models;

import com.dk.myownecommerce.core.model.BaseEntity;
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
public class Account extends BaseEntity {
    private boolean isClosed;
    private LocalDateTime open;
    private LocalDateTime closed;
    private String billingAddress;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
