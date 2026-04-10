package com.champsoft.hrms.modules.bookings.application.port.out;

import com.champsoft.hrms.modules.bookings.domain.model.*;

import java.util.List;
import java.util.Optional;

public interface BookingRepositoryPort {

    Booking save(Booking booking);

    Optional<Booking> findById(BookingId id);

    List<Booking> findAll();

    void deleteById(BookingId id);
}