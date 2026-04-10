package com.champsoft.hrms.modules.bookings.infrastructure.acl;

import com.champsoft.hrms.modules.bookings.application.port.out.GuestEligibilityPort;
import com.champsoft.hrms.modules.guests.application.service.GuestEligibilityService;
import org.springframework.stereotype.Component;

@Component
public class GuestEligibilityAdapter implements GuestEligibilityPort {

    private final GuestEligibilityService guestEligibilityService;

    public GuestEligibilityAdapter(GuestEligibilityService guestEligibilityService) {
        this.guestEligibilityService = guestEligibilityService;
    }

    @Override
    public boolean isEligible(String guestId) {
        return guestEligibilityService.isEligible(guestId);
    }
}