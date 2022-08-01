package com.example.redisconfig.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ExceptionDetails handleException(ResourceNotFoundException resourceNotFoundException){
        return new ExceptionDetails(resourceNotFoundException.getMessage(),HttpStatus.NOT_FOUND,resourceNotFoundException);
    }
}
