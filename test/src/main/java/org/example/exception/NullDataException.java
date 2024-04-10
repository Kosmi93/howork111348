package org.example.exception;

public class NullDataException extends RuntimeException {
    public NullDataException() {
    }

    public NullDataException(String message) {
        super(message);
    }
}
