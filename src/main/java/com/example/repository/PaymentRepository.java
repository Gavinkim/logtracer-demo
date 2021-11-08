package com.example.repository;

import com.example.dto.PaymentCancelReq;
import com.example.dto.PaymentCancelRes;
import com.example.dto.PaymentReq;
import com.example.dto.PaymentRes;
import com.example.dto.PaymentResult;
import com.example.dto.PaymentTransactionReq;
import com.example.dto.PaymentTransactionRes;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

  public PaymentRes payment(PaymentReq request) {
    return PaymentRes.builder()
        .itemId(request.getItemId())
        .userId(request.getUserId())
        .paymentKey(request.getPaymentKey())
        .result(PaymentResult.SUCCESS)
        .build();
  }

  public PaymentCancelRes cancel(PaymentCancelReq request) {
    return PaymentCancelRes.builder()
        .amount(request.getAmount())
        .paymentKey(request.getPaymentKey())
        .userId(request.getUserId())
        .result(PaymentResult.SUCCESS)
        .build();
  }

  public PaymentTransactionRes transaction(PaymentTransactionReq request) {
    return PaymentTransactionRes.builder()
        .amount("20000")
        .itemId("DIA-100")
        .paymentKey(request.getPaymentKey())
        .userId(request.getUserId())
        .build();
  }


}
