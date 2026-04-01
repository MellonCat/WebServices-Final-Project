package com.champsoft.hrms.modules.bookings.application.exception;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String message) {
        super(message);
    }
}
