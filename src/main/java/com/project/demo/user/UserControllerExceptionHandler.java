package com.project.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserControllerExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exc) {


        UserErrorResponse error = new UserErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(Exception exc) {

        UserErrorResponse error = new UserErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Value input is a String; A positive int within range is required");
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

}
