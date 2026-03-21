package com.springbatch.test.exception;

public class ProductDataException extends Exception {

    public ProductDataException(String message) {
        super(message);
    }

    public ProductDataException(String message, Throwable cause) {
        super(message, cause);
    }
}