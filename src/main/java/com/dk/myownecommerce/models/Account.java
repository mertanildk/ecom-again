package com.dk.myownecommerce.models;

import com.dk.myownecommerce.core.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    private Customer customer;
}
