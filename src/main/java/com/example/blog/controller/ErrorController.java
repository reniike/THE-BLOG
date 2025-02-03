package com.example.blog.controller;

import com.example.blog.dtos.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Slf4j
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalExceptionHandler> handleException(Exception ex){
        log.error(ex.getMessage());
        GlobalExceptionHandler globalExceptionHandler = GlobalExceptionHandler.builder()
                .message("An error occurred")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return new ResponseEntity<>(globalExceptionHandler, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<GlobalExceptionHandler> handleException(IllegalArgumentException ex){
        log.error(ex.getMessage());
        GlobalExceptionHandler globalExceptionHandler = GlobalExceptionHandler.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(globalExceptionHandler, HttpStatus.BAD_REQUEST);
    }
}
