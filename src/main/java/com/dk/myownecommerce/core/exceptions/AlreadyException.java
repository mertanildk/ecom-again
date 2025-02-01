package com.dk.myownecommerce.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public abstract class AlreadyException extends RuntimeException {

    /**
     * Constructs an {@code AlreadyException} with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     */
    protected AlreadyException(String message) {
        super(message);
    }

}