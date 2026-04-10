package com.champsoft.hrms.modules.payment.api.dto;

import com.champsoft.hrms.modules.payment.domain.model.PaymentType;

public record PaymentResponse(
        String id,
        String cardNumber,
        String expiryDate,
        double amount,
        PaymentType type,
        String status
) {}