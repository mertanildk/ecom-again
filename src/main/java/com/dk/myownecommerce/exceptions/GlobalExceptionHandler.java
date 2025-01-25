package com.dk.myownecommerce.exceptions;

import com.dk.myownecommerce.core.exceptions.BaseException;
import com.dk.myownecommerce.core.exceptions.CustomError;
import com.dk.myownecommerce.core.exceptions.ErrorResponseBuilder;
import com.dk.myownecommerce.core.model.exception.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.dk.myownecommerce.core.exceptions.CustomError.Header.*;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<CustomError> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex) {
        List<CustomError.CustomSubError> subErrors = extractValidationErrors(ex);
        CustomError customError = ErrorResponseBuilder.
                buildErrorResponse
                        (HttpStatus.BAD_REQUEST, "Validation failed", subErrors, VALIDATION_ERROR.name());
        return ResponseEntity.badRequest().body(customError);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<CustomError> handleRuntimeException(final RuntimeException runtimeException) {
        CustomError customError = ErrorResponseBuilder
                .buildErrorResponse
                        (HttpStatus.NOT_FOUND, runtimeException.getMessage(), API_ERROR.name());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customError);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<CustomError> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        String message = "The requested HTTP method is not supported. Supported methods are: "
                + String.join(", ", Objects.requireNonNull(ex.getSupportedMethods()));
        CustomError customError = ErrorResponseBuilder
                .buildErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, message, API_ERROR.name());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(customError);
    }

    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<CustomError> handleAccessDeniedException(final AccessDeniedException exception) {
        CustomError customError = ErrorResponseBuilder
                .buildErrorResponse(HttpStatus.FORBIDDEN, exception.getMessage(), AUTH_ERROR.name());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(customError);
    }


    private List<CustomError.CustomSubError> extractValidationErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors().stream()
                .map(this::createCustomSubError)
                .collect(Collectors.toList());
    }

    private CustomError.CustomSubError createCustomSubError(org.springframework.validation.ObjectError error) {
        String fieldName = (error instanceof FieldError)
                ? ((FieldError) error).getField()
                : error.getObjectName();  // Fallback to object name if not FieldError
        String message = error.getDefaultMessage();
        return CustomError.CustomSubError.builder()
                .field(fieldName)
                .message(message)
                .build();
    }
}
