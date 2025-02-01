package com.dk.myownecommerce.models;

import com.dk.myownecommerce.core.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart extends BaseEntity {
    private LocalDateTime created;

    @OneToOne
    @JoinColumn(name = "web_user_id")
    private WebUser webUser;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineItem> items;

    // Getters and setters
}
