package com.dk.myownecommerce.core.model.mapper;

import com.dk.myownecommerce.models.Category;
import com.dk.myownecommerce.models.Product;
import com.dk.myownecommerce.models.dto.request.ProductAddRequestDTO;
import com.dk.myownecommerce.models.dto.response.ProductResponseDTO;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class ProductMapper {


    public static Product mapForSaving(ProductAddRequestDTO dto, Category defaultCategory) {
        return Product.builder()
                .name(dto.name())
                .description(dto.description())
                .brand(dto.brand())
                .price(dto.price())
                .stock(dto.stock()==null ? 30 : dto.stock())
                .category(dto.category() != null
                        ? CategoryMapper.toEntity(dto.category())
                        : defaultCategory)
                .build();
    }


    public static ProductResponseDTO mapForResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getName(),
                product.getDescription(),
                product.getBrand(),
                product.getPrice(),
                product.getStock(),
                CategoryMapper.mapForResponse(product.getCategory())
        );
    }

    public static Set<ProductResponseDTO> mapForResponseDTO(Set<Product> products) {
        return products.stream()
                .map(ProductMapper::mapForResponseDTO)
                .collect(Collectors.toSet());
    }
}
