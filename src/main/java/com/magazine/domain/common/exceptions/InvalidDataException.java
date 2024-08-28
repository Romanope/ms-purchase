package com.magazine.domain.common.exceptions;

public class InvalidDataException extends RuntimeException {

    public InvalidDataException(final String message) {
        super(message);
    }
}
