package com.dk.myownecommerce.component.initializer;

import com.dk.myownecommerce.core.util.JwtUtil;
import com.dk.myownecommerce.models.Category;
import com.dk.myownecommerce.models.WebUser;
import com.dk.myownecommerce.repositories.CategoryRepository;
import com.dk.myownecommerce.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public DataInitializer(CategoryRepository categoryRepository, UserRepository userRepository, JwtUtil jwtUtil) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void run(String... args) {
        WebUser user = new WebUser();
        user.setUsername("admin");
        user.setEmail("admin@example.com");
        /*SignatureAlgorithm.HS256*/
        user.setPassword(jwtUtil.encodePassword("password"));
        userRepository.save(user);
        System.out.println("DataInitializer.run");
        if (categoryRepository.count() == 0) {
            System.out.println("DataInitializer.run - categoryRepository.count() == 0");
            categoryRepository.save(new Category("Default","Default Category"));
        }

    }
}
