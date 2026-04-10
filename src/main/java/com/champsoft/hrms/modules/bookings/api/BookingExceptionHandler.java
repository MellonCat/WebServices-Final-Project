package com.champsoft.hrms.modules.bookings.api;

import com.champsoft.hrms.modules.bookings.application.exception.*;
import com.champsoft.hrms.modules.bookings.domain.exception.*;
import com.champsoft.hrms.shared.web.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestControllerAdvice(assignableTypes = BookingController.class)
public class BookingExceptionHandler {

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> notFound(
            BookingNotFoundException ex,
            HttpServletRequest req
    ) {
        return build(HttpStatus.NOT_FOUND, ex, req);
    }

    @ExceptionHandler(RoomNotAvailableException.class)
    public ResponseEntity<ApiErrorResponse> conflict(
            RoomNotAvailableException ex,
            HttpServletRequest req
    ) {
        return build(HttpStatus.CONFLICT, ex, req);
    }

    @ExceptionHandler(CrossContextValidationException.class)
    public ResponseEntity<ApiErrorResponse> unprocessable(
            CrossContextValidationException ex,
            HttpServletRequest req
    ) {
        return build(HttpStatus.valueOf(422), ex, req);
    }

    @ExceptionHandler({
            InvalidBookingDateException.class,
            IllegalArgumentException.class
    })
    public ResponseEntity<ApiErrorResponse> badRequest(
            RuntimeException ex,
            HttpServletRequest req
    ) {
        return build(HttpStatus.BAD_REQUEST, ex, req);
    }

    @ExceptionHandler({
            com.champsoft.hrms.modules.rooms.application.exception.RoomNotFoundException.class,
            com.champsoft.hrms.modules.guests.application.exception.GuestNotFoundException.class,
            com.champsoft.hrms.modules.payment.application.exception.PaymentNotFoundException.class
    })
    public ResponseEntity<ApiErrorResponse> notFound(
            RuntimeException ex,
            HttpServletRequest req
    ) {
        return build(HttpStatus.NOT_FOUND, ex, req);
    }

    private ResponseEntity<ApiErrorResponse> build(
            HttpStatus status,
            Exception ex,
            HttpServletRequest req
    ) {
        var body = new ApiErrorResponse(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
        );

        return ResponseEntity.status(status).body(body);
    }
}