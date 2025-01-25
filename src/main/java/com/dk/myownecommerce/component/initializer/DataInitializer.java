package com.dk.myownecommerce.component.initializer;

import com.dk.myownecommerce.models.Category;
import com.dk.myownecommerce.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public DataInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DataInitializer.run");
        if (categoryRepository.count() == 0) {
            System.out.println("DataInitializer.run - categoryRepository.count() == 0");
            categoryRepository.save(new Category("Default","Default Category"));
        }

    }
}
