package com.dk.myownecommerce.exceptions;

import com.dk.myownecommerce.core.exceptions.AlreadyException;

public class UsernameAlreadyException extends AlreadyException {

    private final static String DEFAULT_MESSAGE_ID = "Username already exists: ";
    private final static String DEFAULT_MESSAGE = "Username already exists";

    /**
     * Constructs an {@code AlreadyException} with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     */
    public UsernameAlreadyException(String message) {
        super(DEFAULT_MESSAGE_ID.concat(message));
    }
    public UsernameAlreadyException() {
        super(DEFAULT_MESSAGE);
    }
}
