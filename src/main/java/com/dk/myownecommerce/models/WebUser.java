package com.dk.myownecommerce.models;

import com.dk.myownecommerce.core.model.BaseEntity;
import com.dk.myownecommerce.models.enums.UserState;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebUser extends BaseEntity {
    private String loginId;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserState state;
    @OneToOne
    private Customer customer;
}
