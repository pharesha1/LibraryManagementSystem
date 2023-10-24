package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.exception.LibrarianErrorResponse;
import com.example.librarymanagementsystem.exception.LibrarianNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//exception handler for all apis
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<LibrarianErrorResponse> handleException(LibrarianNotFoundException exc){
        LibrarianErrorResponse error = new LibrarianErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<LibrarianErrorResponse> handleException(Exception exc){
        LibrarianErrorResponse error = new LibrarianErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
