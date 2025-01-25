package com.dk.myownecommerce.core.model.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustomException<E> {

    private String hostName;

    private String path;

    private Date createTime;

    private E message;
}
