package com.champsoft.hrms.modules.payment.api.dto;

import com.champsoft.hrms.modules.payment.domain.model.PaymentType;
import jakarta.validation.constraints.*;

public record CreatePaymentRequest(
        @NotBlank String cardNumber,
        @NotBlank String expiryDate,
        @Positive double amount,
        @NotNull PaymentType type
) {}