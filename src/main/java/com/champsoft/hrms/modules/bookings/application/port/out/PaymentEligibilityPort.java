package com.champsoft.hrms.modules.bookings.application.port.out;

public interface PaymentEligibilityPort {
    boolean isEligible(String paymentId);
}
