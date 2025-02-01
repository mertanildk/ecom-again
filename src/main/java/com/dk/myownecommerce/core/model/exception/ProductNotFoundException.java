package com.dk.myownecommerce.core.model.exception;

import com.dk.myownecommerce.core.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends NotFoundException {


    private static final String DEFAULT_MESSAGE =
            "The specified Product is not found!";
    public static final String MODEL_NOT_FOUND_MESSAGE =
            "The specified Product with model id {0} is not found!";


    public ProductNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ProductNotFoundException(String id) {
        super(MessageFormat.format(MODEL_NOT_FOUND_MESSAGE, id));
    }
}
