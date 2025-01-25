package com.dk.myownecommerce.core.exceptions;

import com.dk.myownecommerce.core.model.exception.ErrorMessage;

public class BaseException extends RuntimeException{

    public BaseException() {

    }

    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
    }
}
