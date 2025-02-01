package com.dk.myownecommerce.constants.messages;

import lombok.experimental.UtilityClass;

import java.util.ResourceBundle;

@UtilityClass
public class MessageConstants {
    private static final ResourceBundle messages = ResourceBundle.getBundle("messages.messages");

    public static String getMessage(final String message) {
        return messages.getString(message);
    }
    public static String NOT_FOUND = getMessage("not.found");
    public static String SIGNUP_OK = getMessage("signup.ok");

}
