package com.example.demo.exceptions;

public class CodeLengthException extends RuntimeException{

    public CodeLengthException() {
    }

    public CodeLengthException(String message) {
        super(message);
    }

    public CodeLengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public CodeLengthException(Throwable cause) {
        super(cause);
    }

    public CodeLengthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
