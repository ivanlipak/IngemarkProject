package com.example.demo.exceptions;

public class ProductExistsException extends RuntimeException {

    public ProductExistsException(String message) {
        super(message);
    }
}
