package com.champsoft.hrms.modules.payment.domain.exception;

public class InvalidExpiryDateException extends RuntimeException {
    public InvalidExpiryDateException(String message) {
        super(message);
    }
}
