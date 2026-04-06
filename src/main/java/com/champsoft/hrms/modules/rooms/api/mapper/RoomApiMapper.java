package com.champsoft.hrms.modules.rooms.api.mapper;

import com.champsoft.hrms.modules.rooms.api.dto.RoomResponse;
import com.champsoft.hrms.modules.rooms.domain.model.Room;

public class RoomApiMapper {

    public static RoomResponse toResponse(Room room) {
        return new RoomResponse(
                room.id().value(),
                room.roomNumber().value(),
                room.details().roomType(),
                room.details().pricePerNight(),
                room.status().name()
        );
    }
}