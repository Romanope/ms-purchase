package com.magazine.domain.common;

public class CustomerNotFoundException extends NotFoundException {

    public CustomerNotFoundException(final String message) {
        super(message);
    }
}
