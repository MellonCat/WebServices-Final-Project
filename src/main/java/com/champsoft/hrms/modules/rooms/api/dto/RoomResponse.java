package com.champsoft.hrms.modules.rooms.api.dto;

import com.champsoft.hrms.modules.rooms.domain.model.RoomType;

public record RoomResponse(
        String id,
        String roomNumber,
        RoomType roomType,
        double pricePerNight,
        String status
) {}