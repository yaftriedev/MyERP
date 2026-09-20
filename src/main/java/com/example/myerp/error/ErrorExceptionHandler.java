package com.example.myerp.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ResponseError> handleErrorException(ErrorException e) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new ResponseError(e.getMessage()));
    }
}
