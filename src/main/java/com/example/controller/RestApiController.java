package com.example.controller;

import com.example.annotation.LogTrace;
import com.example.dto.PaymentCancelReq;
import com.example.dto.PaymentCancelRes;
import com.example.dto.PaymentReq;
import com.example.dto.PaymentRes;
import com.example.dto.PaymentTransactionReq;
import com.example.dto.PaymentTransactionRes;
import com.example.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestApiController {

  private final PaymentService paymentService;

  @LogTrace
  @PostMapping("/payment")
  public ResponseEntity<?> payment(@RequestBody PaymentReq request) throws Exception {
    PaymentRes response = paymentService.payment(request);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/cancel")
  public ResponseEntity<?> cancel(@RequestBody PaymentCancelReq request){
    PaymentCancelRes response = paymentService.cancel(request);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/transaction")
  public ResponseEntity<?> transaction(@RequestBody PaymentTransactionReq request){
    PaymentTransactionRes response = paymentService.transaction(request);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
