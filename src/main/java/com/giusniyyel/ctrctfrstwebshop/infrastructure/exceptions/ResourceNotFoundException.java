package com.giusniyyel.ctrctfrstwebshop.infrastructure.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
