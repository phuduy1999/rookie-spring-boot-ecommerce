package com.nashtech.rookies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ForeignKeyException extends RuntimeException {
    public ForeignKeyException(String message) {
        super(message);
    }
}