package com.dk.myownecommerce.controllers;

import com.dk.myownecommerce.core.model.apiResponse.CustomResponse;
import com.dk.myownecommerce.models.dto.request.ProductAddRequestDTO;
import com.dk.myownecommerce.models.dto.response.ProductResponseDTO;
import com.dk.myownecommerce.services.ProductService;
import jakarta.validation.Valid;
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
    public CustomResponse<Set<ProductResponseDTO>> getAllProducts() {
        return CustomResponse.successOf(productService.getAllProducts());
    }
    @GetMapping("/by-id/{id}")
    public CustomResponse<ProductResponseDTO> getProductById(@PathVariable String id) {
        return CustomResponse.successOf(productService.getProductById(id));
    }
    @PostMapping("/create")
    public CustomResponse<ProductResponseDTO> createProduct(@RequestBody ProductAddRequestDTO productRequestDTO) {
        return CustomResponse.successOf(productService.createProduct(productRequestDTO));
    }

}
