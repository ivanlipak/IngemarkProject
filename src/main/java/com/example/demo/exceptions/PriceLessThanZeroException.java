package com.example.demo.exceptions;

public class PriceLessThanZeroException extends RuntimeException {
    public PriceLessThanZeroException() {
    }

    public PriceLessThanZeroException(String message) {
        super(message);
    }

    public PriceLessThanZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public PriceLessThanZeroException(Throwable cause) {
        super(cause);
    }

    public PriceLessThanZeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
