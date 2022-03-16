package com.desafio3.Desafio3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AvionNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AvionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String AvionNotFoundHandler(AvionNotFoundException ex){
        return ex.getMessage();
    }
}
