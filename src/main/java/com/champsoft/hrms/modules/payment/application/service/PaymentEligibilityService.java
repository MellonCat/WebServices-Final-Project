package com.champsoft.hrms.modules.payment.application.service;

import com.champsoft.hrms.modules.payment.application.exception.PaymentNotFoundException;
import com.champsoft.hrms.modules.payment.application.port.out.PaymentRepositoryPort;
import com.champsoft.hrms.modules.payment.domain.model.PaymentId;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentEligibilityService {

    private final PaymentRepositoryPort repo;

    public PaymentEligibilityService(PaymentRepositoryPort repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public boolean isEligible(String paymentId) {
        return repo.findById(PaymentId.of(paymentId))
                .map(payment -> payment.isEligibleForProcessing())
                .orElseThrow(() ->
                        new PaymentNotFoundException("Payment not found: " + paymentId)
                );
    }
}