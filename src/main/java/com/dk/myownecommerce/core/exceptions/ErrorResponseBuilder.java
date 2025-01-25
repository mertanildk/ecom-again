package com.dk.myownecommerce.core.exceptions;

import org.springframework.http.HttpStatus;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class ErrorResponseBuilder {
    public static CustomError buildErrorResponse(HttpStatus status, String message, List<CustomError.CustomSubError> subErrors, String header) {
        return CustomError.builder()
                .httpStatus(status.value())
                .header(header)
                .message(message)
                .hostAddress(getHostname())
                .subErrors(subErrors)
                .build();
    }

    public static CustomError buildErrorResponse(HttpStatus status, String message, String header) {
        return buildErrorResponse(status, message, null, header);
    }

    private static String getHostname() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "UnknownHost";
        }
    }
}
