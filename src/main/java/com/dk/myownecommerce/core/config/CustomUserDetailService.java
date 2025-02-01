package com.dk.myownecommerce.core.config;

import com.dk.myownecommerce.models.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface CustomUserDetailService extends UserDetailsService {
    WebUser registerUser(String username, String password, String email);
}
