package com.dk.myownecommerce.core.service;

import com.dk.myownecommerce.core.config.CustomUserDetailService;
import com.dk.myownecommerce.core.model.AuthenticationRequest;
import com.dk.myownecommerce.core.model.AuthenticationResponse;
import com.dk.myownecommerce.core.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JwtService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailService userDetailsService;
    private final JwtUtil jwtUtil;

    public JwtService(AuthenticationManager authenticationManager, CustomUserDetailService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return AuthenticationResponse.builder()
                .isSuccess(true)
                .jwt(jwt)
                .endTime(LocalDateTime.now().plusSeconds(jwtUtil.getExpirationTime()))
                .message("Authentication successful")
                .build();
    }
}