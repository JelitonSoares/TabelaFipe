package br.com.jeli.fipeveiculos.models.exception;

public class DomainException extends RuntimeException{
    public DomainException(String message) {
        super(message);
    }
}
