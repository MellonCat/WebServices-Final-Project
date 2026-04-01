package com.champsoft.hrms.modules.room.application.exception;

public class DuplicateRoomNumberException extends RuntimeException {
    public DuplicateRoomNumberException(String message) {
        super(message);
    }
}
