package com.champsoft.hrms.modules.bookings.infrastructure.acl;

import com.champsoft.hrms.modules.bookings.application.port.out.RoomEligibilityPort;
import com.champsoft.hrms.modules.rooms.application.service.RoomEligibilityService;
import org.springframework.stereotype.Component;

@Component
public class RoomEligibilityAdapter implements RoomEligibilityPort {

    private final RoomEligibilityService roomsEligibility;

    public RoomEligibilityAdapter(RoomEligibilityService roomsEligibility) {
        this.roomsEligibility = roomsEligibility;
    }

    @Override
    public boolean isEligible(String roomId) {
        return roomsEligibility.isEligible(roomId);
    }
}