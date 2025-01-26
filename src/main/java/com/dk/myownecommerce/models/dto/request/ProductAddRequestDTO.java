package com.dk.myownecommerce.models.dto.request;

import jakarta.annotation.Nullable;

public record ProductAddRequestDTO(String name,
                                   String description,
                                   String brand,
                                   String price,
                                   Integer stock,
                                   @Nullable
                                   CategoryRequestDTO category) {
}