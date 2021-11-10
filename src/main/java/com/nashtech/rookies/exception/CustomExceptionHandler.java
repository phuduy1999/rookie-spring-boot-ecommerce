package com.nashtech.rookies.exception;

import com.nashtech.rookies.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDto> handleNotFoundException(NotFoundException ex, WebRequest request) {
        ResponseDto responseDto = new ResponseDto(ex.getMessage(), request.getDescription(false), null);
        return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UniqueConstraintException.class)
    public ResponseEntity<String> handlerUniqueConstraintException(UniqueConstraintException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ConvertDTOException.class)
    public ResponseEntity<String> handlerConvertDTOException(ConvertDTOException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ForeignKeyException.class)
    public ResponseEntity<String> handlerForeignKeyException(ForeignKeyException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(NullFieldException.class)
    public ResponseEntity<String> handlerEmptyFieldException(NullFieldException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<String> handleBindException(BindException e) {
        String errorMessage = "";
        if (e.getBindingResult().hasErrors())
            errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(SaveErrorException.class)
    public ResponseEntity<ResponseDto> handleSaveErrorException(SaveErrorException ex, WebRequest request) {
        ResponseDto responseDto = new ResponseDto(ex.getMessage(), request.getDescription(false), null);
        return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseDto> handleIdNotFoundException(IdNotFoundException ex, WebRequest request) {
        ResponseDto responseDto = new ResponseDto(ex.getMessage(), request.getDescription(false), null);
        return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNameExistException.class)
    public ResponseEntity<ResponseDto> handleCategoryNameExistException(CategoryNameExistException ex, WebRequest request) {
        ResponseDto responseDto = new ResponseDto(ex.getMessage(), request.getDescription(false), null);
        return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryExistInProductException.class)
    public ResponseEntity<ResponseDto> handleCategoryExistInProductException(CategoryExistInProductException ex,
                                                                       WebRequest request) {
        ResponseDto responseDto = new ResponseDto(ex.getMessage(), request.getDescription(false), null);
        return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UpdateErrorException.class)
    public ResponseEntity<ResponseDto> handleUpdateErrorException(UpdateErrorException ex, WebRequest request) {
        ResponseDto responseDto = new ResponseDto(ex.getMessage(), request.getDescription(false), null);
        return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DeleteErrorException.class)
    public ResponseEntity<ResponseDto> handleDeleteErrorException(DeleteErrorException ex, WebRequest request) {
        ResponseDto responseDto = new ResponseDto(ex.getMessage(), request.getDescription(false), null);
        return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnwantedException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}