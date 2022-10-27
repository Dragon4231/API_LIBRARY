package com.example.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PrintedProductException {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleException(HttpMessageNotReadableException e) {
        return new ResponseEntity("some parameters are not set or null", HttpStatus.BAD_REQUEST);
    }

}
