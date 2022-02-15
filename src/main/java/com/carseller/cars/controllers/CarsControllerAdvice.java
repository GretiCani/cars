package com.carseller.cars.controllers;

import com.carseller.cars.commons.exceptions.ExceptionResponse;
import com.carseller.cars.commons.exceptions.ResourceNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class CarsControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    protected ResponseEntity<Object> handleEmployeeNotFound(ResourceNotFound ex){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND,ex.getMessage());
        log.warn("ResourceNotFound: "+exceptionResponse.getMessage());
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());

    }

}
