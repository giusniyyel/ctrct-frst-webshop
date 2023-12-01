package com.giusniyyel.ctrctfrstwebshop.infrastructure.exceptions;

public class CustomerPersistenceException extends RuntimeException {
    public CustomerPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
