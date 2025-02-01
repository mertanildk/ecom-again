package com.dk.myownecommerce.core.config;

import com.dk.myownecommerce.core.util.JwtUtil;
import com.dk.myownecommerce.exceptions.EmailAlreadyException;
import com.dk.myownecommerce.exceptions.UsernameAlreadyException;
import com.dk.myownecommerce.models.WebUser;
import com.dk.myownecommerce.models.dto.request.UserSignUpRequest;
import com.dk.myownecommerce.models.dto.response.UserSignUpResponse;
import com.dk.myownecommerce.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailServiceImpl implements CustomUserDetailService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public CustomUserDetailServiceImpl(UserRepository userRepository, JwtUtil jwtUtil, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<WebUser> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return user.get();
    }

    @Override
    public UserSignUpResponse registerUser(UserSignUpRequest signUpRequest) {
        // Check if the username or email already exists
        WebUser user = saveUser(signUpRequest);
        return mapSignUpResponse(user);
    }

    private WebUser saveUser(UserSignUpRequest signUpRequest) {
        if (userRepository.findByUsername(signUpRequest.username()).isPresent()) {/*TODO ASPECT FOR THESE BUSINESS*/
            throw new UsernameAlreadyException(signUpRequest.username());
        }
        if (userRepository.findByEmail(signUpRequest.email()).isPresent()) {/*TODO ASPECT FOR THESE BUSINESS*/
            throw new EmailAlreadyException(signUpRequest.email());
        }
        // Encode the password
        String encodedPassword = passwordEncoder.encode(signUpRequest.password());
        // Create and save the user
        WebUser webUser = new WebUser(signUpRequest.username(), encodedPassword, signUpRequest.email());
        return userRepository.save(webUser);
    }

    private UserSignUpResponse mapSignUpResponse(WebUser user) {
        return UserSignUpResponse.builder()
                .userName(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
