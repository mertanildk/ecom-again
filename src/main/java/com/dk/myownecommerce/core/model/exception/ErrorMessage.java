package com.dk.myownecommerce.core.model.exception;

public class ErrorMessage {
    private String message;
    private String code;

    public ErrorMessage(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String prepareErrorMessage() {
        return "Error Code: " + code + " - " + message;
    }
}
