package com.champsoft.hrms.modules.rooms.api.dto;

import com.champsoft.hrms.modules.rooms.domain.model.RoomType;
import jakarta.validation.constraints.*;

public record CreateRoomRequest(
        @NotBlank String roomNumber,
        @NotNull RoomType roomType,
        @Positive double pricePerNight
) {}