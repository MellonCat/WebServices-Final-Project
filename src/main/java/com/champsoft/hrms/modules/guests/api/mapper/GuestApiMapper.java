package com.champsoft.hrms.modules.guests.api.mapper;

import com.champsoft.hrms.modules.guests.api.dto.GuestResponse;
import com.champsoft.hrms.modules.guests.domain.model.Guest;

public class GuestApiMapper {
    public static GuestResponse toResponse(Guest g) {
        return new GuestResponse(
                g.id().value(),
                g.fullName().value(),
                g.address().value(),
                g.status().name()
        );
    }
}