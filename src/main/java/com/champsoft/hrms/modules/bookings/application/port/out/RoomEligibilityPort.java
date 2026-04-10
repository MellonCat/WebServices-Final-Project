package com.champsoft.hrms.modules.bookings.application.port.out;

import com.champsoft.hrms.modules.rooms.domain.model.Room;

public interface RoomEligibilityPort {
    boolean isEligible(String roomId);
}
