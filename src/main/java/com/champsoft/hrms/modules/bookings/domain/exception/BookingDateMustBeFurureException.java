package com.champsoft.hrms.modules.bookings.domain.exception;

public class BookingDateMustBeFurureException extends RuntimeException {
    public BookingDateMustBeFurureException(String message) {
        super(message);
    }
}
