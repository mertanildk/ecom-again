package com.dk.myownecommerce.core.config;

import com.dk.myownecommerce.core.util.JwtUtil;
import com.dk.myownecommerce.models.WebUser;
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
    public WebUser registerUser(String username, String password, String email) {
        // Check if the username or email already exists
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // Encode the password
        String encodedPassword = passwordEncoder.encode(password);

        // Create and save the user
        WebUser user = new WebUser(username, encodedPassword, email);
        return userRepository.save(user);
    }
}
