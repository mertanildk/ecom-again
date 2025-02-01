package com.dk.myownecommerce.core.controller;

import com.dk.myownecommerce.core.config.CustomUserDetailService;
import com.dk.myownecommerce.core.model.AuthenticationRequest;
import com.dk.myownecommerce.core.model.AuthenticationResponse;
import com.dk.myownecommerce.core.service.JwtService;
import com.dk.myownecommerce.models.WebUser;
import com.dk.myownecommerce.models.dto.request.UserSignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final JwtService jwtService;
    private final CustomUserDetailService userDetailService;

    public AuthenticationController(JwtService jwtService, CustomUserDetailService userDetailService) {
        this.jwtService = jwtService;
        this.userDetailService = userDetailService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse response = jwtService.authenticate(authenticationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserSignUpRequest signUpRequest) {
        try {
            WebUser user = userDetailService.registerUser(
                    signUpRequest.username(),
                    signUpRequest.password(),
                    signUpRequest.email()
            );
            return ResponseEntity.ok("User registered successfully with ID: " + user.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}