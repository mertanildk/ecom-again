package com.dk.myownecommerce.core.model.mapper;

import com.dk.myownecommerce.models.Category;
import com.dk.myownecommerce.models.dto.request.CategoryRequestDTO;
import com.dk.myownecommerce.models.dto.response.CategoryResponseDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toEntity(CategoryRequestDTO categoryRequestDTO) {
        return Category.builder()
                .name(categoryRequestDTO.name())
                .description(categoryRequestDTO.description())
                .build();
    }

    public static CategoryResponseDTO mapForResponse(Category category) {
        return category == null ? null : new CategoryResponseDTO(
                category.getName(),
                category.getDescription()
        );
    }
}
