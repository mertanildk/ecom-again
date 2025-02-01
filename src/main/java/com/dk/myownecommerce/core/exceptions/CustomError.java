package com.dk.myownecommerce.core.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Builder
public class CustomError {

    @Builder.Default
    private LocalTime time = LocalDateTime.now().toLocalTime();

    private Integer httpStatus;

    private String hostAddress;

    private String header;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @Builder.Default
    private final Boolean isSuccess = false;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CustomSubError> subErrors;

    /**
     * A static class representing a sub-error, which contains additional information about specific
     * aspects of the error, such as a specific field and its associated value.
     */
    @Getter
    @Builder
    public static class CustomSubError {

        private String message;

        private String field;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Object value;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String type;

    }

    /**
     * An enum representing predefined headers for different types of errors.
     * These headers help categorize the error and provide a quick understanding of its context.
     */
    @Getter
    @RequiredArgsConstructor
    public enum Header {

        API_ERROR("API ERROR"),

        ALREADY_EXIST("ALREADY EXIST"),

        NOT_FOUND("NOT EXIST"),

        VALIDATION_ERROR("VALIDATION ERROR"),

        DATABASE_ERROR("DATABASE ERROR"),

        PROCESS_ERROR("PROCESS ERROR"),

        AUTH_ERROR("AUTH ERROR"),

        BAD_REQUEST("BAD_REQUEST");

        private final String name;

    }

}
