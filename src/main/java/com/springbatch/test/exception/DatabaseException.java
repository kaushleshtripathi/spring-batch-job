package com.springbatch.test.exception;

public class DatabaseException extends ProductDataException {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}