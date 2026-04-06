package com.champsoft.hrms.modules.guests.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateGuestRequest(
        @NotBlank String fullName,
        String address) {}