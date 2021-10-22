//package com.nashtech.rookies.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler({NotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ErrorResponse handleNotFoundException(NotFoundException e) {
//        return new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
//    }
//
//    @ExceptionHandler(DuplicateRecordException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponse handlerDuplicateRecordException(DuplicateRecordException e) {
//        return new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErrorResponse handleUnwantedException(Exception e) {
//        e.printStackTrace();
//        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//    }
//}