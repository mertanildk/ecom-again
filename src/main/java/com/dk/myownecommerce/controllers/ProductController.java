package com.dk.myownecommerce.controllers;

import com.dk.myownecommerce.models.dto.request.ProductRequestDTO;
import com.dk.myownecommerce.models.dto.response.ProductResponseDTO;
import com.dk.myownecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/products")
@Valid
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/by-id/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.createProductWithoutCategory(productRequestDTO));
    }

}
