package com.dk.myownecommerce.services;

import com.dk.myownecommerce.core.model.exception.ProductNotFoundException;
import com.dk.myownecommerce.core.model.mapper.ProductMapper;
import com.dk.myownecommerce.models.Category;
import com.dk.myownecommerce.models.Product;
import com.dk.myownecommerce.models.dto.request.ProductAddRequestDTO;
import com.dk.myownecommerce.models.dto.response.ProductResponseDTO;
import com.dk.myownecommerce.repositories.ProductRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Setter
    private Category defaultCategory;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponseDTO getProductById(String id) {
         return ProductMapper.mapForResponseDTO(
                 productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException(id)));
    }

    public ProductResponseDTO createProduct(ProductAddRequestDTO dto) {
        Product product = ProductMapper.mapForSaving(dto, defaultCategory);
        return ProductMapper.mapForResponseDTO(productRepository.save(product));
    }


    public Set<ProductResponseDTO> getAllProducts() {
        return ProductMapper.mapForResponseDTO(productRepository.findAllProducts());

    }

}
