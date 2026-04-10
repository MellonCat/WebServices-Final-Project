package com.champsoft.hrms.modules.bookings.api.mapper;

import com.champsoft.hrms.modules.bookings.api.dto.BookingResponse;
import com.champsoft.hrms.modules.bookings.domain.model.Booking;

public class BookingApiMapper {

    public static BookingResponse toResponse(Booking b) {
        return new BookingResponse(
                b.id().value(),
                b.roomIdValue(),
                b.guestIdValue(),
                b.paymentIdValue(),
                b.startDateValue(),
                b.endDateValue(),
                b.status().name()
        );
    }
}