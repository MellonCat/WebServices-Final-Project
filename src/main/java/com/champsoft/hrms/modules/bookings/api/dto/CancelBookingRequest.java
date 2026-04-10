package com.champsoft.hrms.modules.bookings.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CancelBookingRequest(

        @NotBlank String id

) {
    /**
     * Backward-compatible accessor for earlier naming.
     */
    public String bookingId() {
        return id;
    }
}