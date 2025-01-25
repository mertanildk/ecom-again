package com.dk.myownecommerce.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse<E> {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String path;
    private String hostName;
    private E exception;

    // Constructor
    public ErrorResponse(int status, String error, String path,String hostName) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.path = path;
        this.hostName = hostName;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", error='" + error + '\'' +
                ", path='" + path + '\'' +
                ", exception=" + exception +
                '}';
    }
}

