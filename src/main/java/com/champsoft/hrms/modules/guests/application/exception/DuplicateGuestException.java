package com.champsoft.hrms.modules.guests.application.exception;

public class DuplicateGuestException extends RuntimeException {
    public DuplicateGuestException(String message) {
        super(message);
    }
}
