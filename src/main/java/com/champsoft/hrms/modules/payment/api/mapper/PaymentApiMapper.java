package com.champsoft.hrms.modules.payment.api.mapper;

import com.champsoft.hrms.modules.payment.api.dto.PaymentResponse;
import com.champsoft.hrms.modules.payment.domain.model.Payment;

public class PaymentApiMapper {

    public static PaymentResponse toResponse(Payment payment) {
        return new PaymentResponse(
                payment.id().value(),
                payment.cardNumber().value(),
                payment.expiryDate(),
                payment.amount(),
                payment.type(),
                payment.status().name()
        );
    }
}