package com.dk.myownecommerce.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BCryptPasswordEncoderBean {

    @Bean
    public org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder passwordEncoder() {
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }
}
