package com.example.service;

import com.example.dto.PaymentCancelReq;
import com.example.dto.PaymentCancelRes;
import com.example.dto.PaymentReq;
import com.example.dto.PaymentRes;
import com.example.dto.PaymentTransactionReq;
import com.example.dto.PaymentTransactionRes;
import com.example.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {

  private final PaymentRepository paymentRepository;

  public PaymentRes payment(PaymentReq request) {
    return paymentRepository.payment(request);
  }
  public PaymentCancelRes cancel(PaymentCancelReq request) {
    return paymentRepository.cancel(request);
  }
  public PaymentTransactionRes transaction(PaymentTransactionReq request) {
    return paymentRepository.transaction(request);
  }
}
