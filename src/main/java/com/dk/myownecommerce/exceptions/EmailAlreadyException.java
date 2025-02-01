package com.dk.myownecommerce.exceptions;

import com.dk.myownecommerce.core.exceptions.AlreadyException;

public class EmailAlreadyException extends AlreadyException {

    private final static String DEFAULT_MESSAGE_ID = "Email already exists: ";
    private final static String DEFAULT_MESSAGE = "Email already exists";

    /**
     * Constructs an {@code AlreadyException} with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     */
    public EmailAlreadyException(String message) {
        super(DEFAULT_MESSAGE_ID.concat(message));
    }
    public EmailAlreadyException() {
        super(DEFAULT_MESSAGE);
    }
}
