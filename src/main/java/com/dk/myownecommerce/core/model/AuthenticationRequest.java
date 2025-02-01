package com.dk.myownecommerce.core.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthenticationRequest {
    private String username;
    private String password;
}
