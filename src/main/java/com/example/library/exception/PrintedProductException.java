package com.example.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class PrintedProductException {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleNotReadableException() {
        return new ResponseEntity("some parameters are not set or null", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity handleNoSuchElementException() {
        return new ResponseEntity("no elements with this value were found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleIllegalArgumentException() {
        return new ResponseEntity("no elements of this Type (VALID : BOOK, NEWSPAPER, JOURNAL)", HttpStatus.NOT_FOUND);
    }
}
