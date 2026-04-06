package com.champsoft.hrms.modules.rooms.domain.model;

public record RoomDetails(double pricePerNight, RoomType roomType) {

    public RoomDetails {
        if (pricePerNight <= 0) throw new IllegalArgumentException("Price per night must be greater than 0");
        if (roomType == null) throw new IllegalArgumentException("Room type is required");
    }
}