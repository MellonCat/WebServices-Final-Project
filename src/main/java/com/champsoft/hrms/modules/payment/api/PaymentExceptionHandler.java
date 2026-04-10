package com.champsoft.hrms.modules.payment.api;

import com.champsoft.hrms.modules.payment.application.exception.PaymentNotFoundException;
import com.champsoft.hrms.modules.payment.domain.exception.InvalidCardNumberException;
import com.champsoft.hrms.shared.web.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestControllerAdvice(assignableTypes = PaymentController.class)
public class PaymentExceptionHandler {

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> notFound(
            PaymentNotFoundException ex,
            HttpServletRequest req
    ) {
        return build(HttpStatus.NOT_FOUND, ex, req);
    }

    @ExceptionHandler(InvalidCardNumberException.class)
    public ResponseEntity<ApiErrorResponse> badRequest(
            InvalidCardNumberException ex,
            HttpServletRequest req
    ) {
        return build(HttpStatus.BAD_REQUEST, ex, req);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> badRequestGeneric(
            IllegalArgumentException ex,
            HttpServletRequest req
    ) {
        return build(HttpStatus.BAD_REQUEST, ex, req);
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> validation(
            org.springframework.web.bind.MethodArgumentNotValidException ex,
            HttpServletRequest req
    ) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(err -> err.getField() + " " + err.getDefaultMessage())
                .orElse("Validation failed");

        return build(HttpStatus.BAD_REQUEST, new IllegalArgumentException(message), req);
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