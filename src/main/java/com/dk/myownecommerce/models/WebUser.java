package com.dk.myownecommerce.models;

import com.dk.myownecommerce.core.model.BaseEntity;
import com.dk.myownecommerce.models.enums.UserState;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebUser extends BaseEntity implements UserDetails {
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserState state=UserState.NEW;
    @OneToOne
    private Customer customer;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public WebUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.state = UserState.NEW;
    }
}
