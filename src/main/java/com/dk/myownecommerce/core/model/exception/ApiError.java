package com.dk.myownecommerce.core.model.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError<E> {

    private Integer status;

    private CustomException<E> exception;
}
