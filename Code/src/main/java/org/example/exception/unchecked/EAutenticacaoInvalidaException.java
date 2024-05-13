package org.example.exception.unchecked;

public class EAutenticacaoInvalidaException extends RuntimeException{

    public EAutenticacaoInvalidaException(String message) {
        super(message);
    }
}
