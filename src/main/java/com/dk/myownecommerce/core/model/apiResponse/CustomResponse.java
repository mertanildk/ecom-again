package com.dk.myownecommerce.core.model.apiResponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Builder
public class CustomResponse<T> {

    @Builder.Default
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time = LocalDateTime.now();

    private Integer httpStatus;

    private Boolean isSuccess;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T response;

    /**
     * A predefined successful response with no data. It represents a successful
     * operation with a HTTP status of 200 (OK).
     */
    public static final CustomResponse<Void> SUCCESS = CustomResponse.<Void>builder()
            .httpStatus(HttpStatus.OK.value())
            .isSuccess(true)
            .build();


    /**
     * Creates a successful response with the provided data.
     *
     * @param response The response data to include in the response body.
     * @param <T>      The type of the response data.
     * @return A {@link CustomResponse} instance with the provided response data.
     */
    public static <T> CustomResponse<T> successOf(final T response) {
        return CustomResponse.<T>builder()
                .httpStatus(HttpStatus.OK.value())
                .isSuccess(true)
                .response(response)
                .build();
    }

    public static <T> CustomResponse<T> successOf(final T response, String message) {
        return CustomResponse.<T>builder()
                .httpStatus(HttpStatus.OK.value())
                .isSuccess(true)
                .message(message)
                .response(response)
                .build();
    }

}