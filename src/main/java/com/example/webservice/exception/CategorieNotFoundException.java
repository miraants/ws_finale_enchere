package com.example.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategorieNotFoundException extends RuntimeException{
    public CategorieNotFoundException(String message) {
        super(message);
    }
}
