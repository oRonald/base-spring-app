package br.com.projeto.crud.base.exception;

public class InvalidPhoneException extends RuntimeException{
    public InvalidPhoneException(String message) {
        super(message);
    }
}
