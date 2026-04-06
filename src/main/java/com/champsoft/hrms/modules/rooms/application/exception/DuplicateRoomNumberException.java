package com.champsoft.hrms.modules.rooms.application.exception;

public class DuplicateRoomNumberException extends RuntimeException {
    public DuplicateRoomNumberException(String message) {
        super(message);
    }
}
