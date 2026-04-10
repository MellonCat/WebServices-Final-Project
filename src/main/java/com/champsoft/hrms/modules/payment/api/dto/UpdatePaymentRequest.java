package com.champsoft.hrms.modules.payment.api.dto;

import jakarta.validation.constraints.*;

public record UpdatePaymentRequest(
        @NotBlank String cardNumber,
        @NotBlank String expiryDate
) {}