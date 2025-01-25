package com.dk.myownecommerce.core.exceptions;

public class NotFoundException extends RuntimeException {

        public NotFoundException() {
            super("Not Found");
        }

        public NotFoundException(String message) {
            super(message);
        }
}
