package com.champsoft.hrms.modules.bookings.infrastructure.acl;

import com.champsoft.hrms.modules.bookings.application.port.out.PaymentEligibilityPort;
import com.champsoft.hrms.modules.payment.application.service.PaymentEligibilityService;
import org.springframework.stereotype.Component;

@Component
public class PaymentEligibilityAdapter implements PaymentEligibilityPort {

    private final PaymentEligibilityService paymentEligibility;

    public PaymentEligibilityAdapter(PaymentEligibilityService paymentEligibility) {
        this.paymentEligibility = paymentEligibility;
    }

    @Override
    public boolean isEligible(String paymentId) {
        return paymentEligibility.isEligible(paymentId);
    }
}
