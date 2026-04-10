package com.champsoft.hrms.modules.bookings.application.port.out;

public interface GuestEligibilityPort {
    boolean isEligible(String guestId);
}
