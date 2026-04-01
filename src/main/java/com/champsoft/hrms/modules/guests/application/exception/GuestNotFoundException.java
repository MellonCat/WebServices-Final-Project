package com.champsoft.hrms.modules.guests.application.exception;

public class GuestNotFoundException extends RuntimeException {
    public GuestNotFoundException(String message) {
        super(message);
    }
}
