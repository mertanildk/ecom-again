package com.dk.myownecommerce.core.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class AuthenticationResponse {
    private String jwt;
    @Builder.Default
    private LocalDateTime startTime = LocalDateTime.now();
    private LocalDateTime endTime;
    private Boolean isSuccess;
    private String message;
}

