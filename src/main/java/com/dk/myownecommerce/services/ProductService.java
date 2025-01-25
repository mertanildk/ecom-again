package com.dk.myownecommerce.services;

import com.dk.myownecommerce.models.Category;
import com.dk.myownecommerce.models.dto.request.ProductRequestDTO;
import com.dk.myownecommerce.models.dto.response.CategoryResponseDTO;
import com.dk.myownecommerce.models.dto.response.ProductResponseDTO;
import com.dk.myownecommerce.repositories.ProductRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Setter
    private Category defaultCategory;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO getProductById(String id) {
        return productRepository.findById(id)
                .map(product -> new ProductResponseDTO(
                        product.getName(),
                        product.getDescription(),
                        product.getBrand(),
                        product.getPrice(),
                        product.getStock(),
                        new CategoryResponseDTO(product.getCategory().getName(),
                                product.getCategory().getDescription())
                ))
                .orElseThrow(() -> new RuntimeException("Product not found"));

    }

    public ProductResponseDTO createProductWithoutCategory(ProductRequestDTO productRequestDTO) {
        /*Product product =
        product.setCategory(defaultCategory);
        Product savedProduct = productRepository.save(product);
        *//*return productMapper.productToResponseDTO(savedProduct);*/
        return null;

    }

    public Set<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponseDTO(
                        product.getName(),
                        product.getDescription(),
                        product.getBrand(),
                        product.getPrice(),
                        product.getStock(),
                        new CategoryResponseDTO(product.getCategory().getName(),
                                product.getCategory().getDescription())
                ))
                .collect(Collectors.toSet());
    }

}
