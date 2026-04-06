package com.champsoft.hrms.modules.guests.api;

import com.champsoft.hrms.modules.guests.application.exception.*;
import com.champsoft.hrms.modules.guests.domain.exception.*;
import com.champsoft.hrms.shared.web.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestControllerAdvice(assignableTypes = GuestController.class)
public class GuestExceptionHandler {

    @ExceptionHandler(GuestNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> notFound(GuestNotFoundException ex, HttpServletRequest req) {
        return build(HttpStatus.NOT_FOUND, ex, req);
    }

    @ExceptionHandler(DuplicateGuestException.class)
    public ResponseEntity<ApiErrorResponse> conflict(DuplicateGuestException ex, HttpServletRequest req) {
        return build(HttpStatus.CONFLICT, ex, req);
    }

    @ExceptionHandler({
            InvalidGuestNameException.class,
            InvalidAddressException.class,
            IllegalArgumentException.class
    })
    public ResponseEntity<ApiErrorResponse> badRequest(RuntimeException ex, HttpServletRequest req) {
        return build(HttpStatus.BAD_REQUEST, ex, req);
    }

    private ResponseEntity<ApiErrorResponse> build(HttpStatus status, Exception ex, HttpServletRequest req) {
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