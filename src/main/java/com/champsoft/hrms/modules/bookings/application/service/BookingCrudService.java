package com.champsoft.hrms.modules.bookings.application.service;

import com.champsoft.hrms.modules.bookings.application.exception.BookingNotFoundException;
import com.champsoft.hrms.modules.bookings.application.port.out.BookingRepositoryPort;
import com.champsoft.hrms.modules.bookings.domain.model.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingCrudService {

    private final BookingRepositoryPort repo;

    public BookingCrudService(BookingRepositoryPort repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public Booking get(String id) {
        return repo.findById(BookingId.of(id))
                .orElseThrow(() -> new BookingNotFoundException("Booking not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Booking> list() {
        return repo.findAll();
    }

    @Transactional
    public Booking cancel(String id) {
        var booking = get(id);
        booking.cancel();
        return repo.save(booking);
    }

    @Transactional
    public void delete(String id) {
        get(id);
        repo.deleteById(BookingId.of(id));
    }
}