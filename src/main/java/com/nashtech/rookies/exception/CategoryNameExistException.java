package com.nashtech.rookies.exception;

public class CategoryNameExistException extends RuntimeException {

    public CategoryNameExistException(String message) {
        super(message);
    }

}