package com.champsoft.hrms.modules.payment.domain.exception;

public class InvalidCardException extends RuntimeException {
    public InvalidCardException(String message) {
        super(message);
    }
}
