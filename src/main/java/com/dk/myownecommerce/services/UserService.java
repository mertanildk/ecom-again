package com.dk.myownecommerce.services;

import com.dk.myownecommerce.core.model.AuthenticationResponse;
import com.dk.myownecommerce.models.dto.request.UserLoginRequest;
import com.dk.myownecommerce.models.dto.request.UserSignUpRequest;
import com.dk.myownecommerce.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> login(UserLoginRequest request) {
            return null;
    }

    public AuthenticationResponse registerUser(UserSignUpRequest signupRequest) {
        return null;
    }
}
