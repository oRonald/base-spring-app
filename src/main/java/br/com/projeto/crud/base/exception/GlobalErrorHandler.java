package br.com.projeto.crud.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(InvalidPhoneException.class)
    public ResponseEntity<GlobalErrorResponse> invalidPhoneException(InvalidPhoneException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GlobalErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                LocalDateTime.now()));
    }
}
