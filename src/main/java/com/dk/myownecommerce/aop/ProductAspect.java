package com.dk.myownecommerce.aop;

import com.dk.myownecommerce.models.Category;
import com.dk.myownecommerce.models.dto.request.ProductRequestDTO;
import com.dk.myownecommerce.repositories.CategoryRepository;
import com.dk.myownecommerce.services.ProductService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProductAspect {
    private final CategoryRepository categoryRepository;
    private final ProductService productService;

    public ProductAspect(CategoryRepository categoryRepository, ProductService productService) {
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }

    @Before("execution(* com.dk.myownecommerce.services.ProductService.createProductWithoutCategory(..)) && args(productRequestDTO)")
    public void setDefaultCategory(ProductRequestDTO productRequestDTO) {
        // Find the default category using categoryRepository
        Category defaultCategory = categoryRepository.findById("1")
                .orElseThrow(() -> new RuntimeException("Default category not found"));
        // Set the default category in ProductService
        productService.setDefaultCategory(defaultCategory);
    }

}
