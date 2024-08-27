package com.magazine.domain.common;

public class InvalidDataException extends RuntimeException {

    public InvalidDataException(final String message) {
        super(message);
    }
}
