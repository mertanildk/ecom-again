package com.dk.myownecommerce.core.controller;

import com.dk.myownecommerce.constants.messages.MessageConstants;
import com.dk.myownecommerce.core.config.CustomUserDetailService;
import com.dk.myownecommerce.core.model.AuthenticationRequest;
import com.dk.myownecommerce.core.model.AuthenticationResponse;
import com.dk.myownecommerce.core.model.apiResponse.CustomResponse;
import com.dk.myownecommerce.core.service.JwtService;
import com.dk.myownecommerce.models.dto.request.UserSignUpRequest;
import com.dk.myownecommerce.models.dto.response.UserSignUpResponse;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dk.myownecommerce.constants.messages.MessageConstants.SIGNUP_OK;

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
    public CustomResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        return CustomResponse.successOf(jwtService.authenticate(authenticationRequest));
    }

    @PostMapping("/signup")
    public CustomResponse<UserSignUpResponse> registerUser(@RequestBody UserSignUpRequest signUpRequest) {
        return CustomResponse.successOf(userDetailService.registerUser(signUpRequest), SIGNUP_OK);

    }
}