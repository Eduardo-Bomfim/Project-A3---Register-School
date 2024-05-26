package org.example.exception.unchecked;

public class EIdNaoEncontradoException extends RuntimeException {
    public EIdNaoEncontradoException(String message) {
        super(message);
    }
}
