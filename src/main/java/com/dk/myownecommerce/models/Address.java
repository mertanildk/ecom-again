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
public class Address extends BaseEntity {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String apartmentNumber;
    private double latitude;
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
