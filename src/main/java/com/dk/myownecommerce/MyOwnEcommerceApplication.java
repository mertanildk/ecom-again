package com.dk.myownecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class MyOwnEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyOwnEcommerceApplication.class, args);
    }

}
