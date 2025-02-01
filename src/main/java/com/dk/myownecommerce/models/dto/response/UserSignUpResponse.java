package com.dk.myownecommerce.models.dto.response;

import lombok.Builder;

@Builder
public record UserSignUpResponse(
        String userName,
        String email
) {
}
