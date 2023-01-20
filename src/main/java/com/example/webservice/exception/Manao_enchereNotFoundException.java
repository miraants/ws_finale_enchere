package com.example.webservice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Manao_enchereNotFoundException  extends RuntimeException{
    public Manao_enchereNotFoundException(String message) {
        super(message);
    }
}
