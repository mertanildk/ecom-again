package com.dk.myownecommerce.core.config;

import com.dk.myownecommerce.models.dto.request.UserSignUpRequest;
import com.dk.myownecommerce.models.dto.response.UserSignUpResponse;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface CustomUserDetailService extends UserDetailsService {
    UserSignUpResponse registerUser(UserSignUpRequest signUpRequest);
}
