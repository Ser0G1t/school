package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value=NullPointerException.class)
    public ResponseEntity<?> valueNotFound(NullPointerException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionJson(e.getMessage()));
    }

}
