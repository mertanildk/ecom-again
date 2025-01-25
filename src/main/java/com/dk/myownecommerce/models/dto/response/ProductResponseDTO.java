package com.dk.myownecommerce.models.dto.response;

import java.io.Serializable;

public record ProductResponseDTO(
        String name,
        String description,
        String brand,
        String price,
        Integer stock,
        CategoryResponseDTO categoryResponseDTO
)implements Serializable { }
