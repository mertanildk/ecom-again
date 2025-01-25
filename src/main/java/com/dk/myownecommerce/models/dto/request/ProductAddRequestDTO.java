package com.dk.myownecommerce.models.dto.request;

import com.dk.myownecommerce.models.dto.response.CategoryResponseDTO;

public record ProductAddRequestDTO(String name,
                                   String description,
                                   String brand,
                                   String price,
                                   Integer stock,
                                   CategoryResponseDTO categoryResponseDTO) {
}