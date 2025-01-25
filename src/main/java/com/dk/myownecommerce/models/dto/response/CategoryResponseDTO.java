package com.dk.myownecommerce.models.dto.response;

import java.io.Serializable;

public record CategoryResponseDTO(
        String name,
        String description) implements Serializable {
}
