package com.champsoft.hrms.modules.rooms.domain.exception;

public class RoomAlreadyOccupiedException extends RuntimeException {
    public RoomAlreadyOccupiedException(String message) {
        super(message);
    }
}
