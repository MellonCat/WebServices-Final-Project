package com.champsoft.hrms.modules.guests.domain.exception;

public class GuestNotEligibleException extends RuntimeException {
    public GuestNotEligibleException(String message) {
        super(message);
    }
}
