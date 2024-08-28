package com.magazine.domain.customer.exceptions;

import com.magazine.domain.common.exceptions.ResourceNotFoundException;

public class CustomerResourceNotFoundException extends ResourceNotFoundException {

    public CustomerResourceNotFoundException(final String message) {
        super(message);
    }
}
