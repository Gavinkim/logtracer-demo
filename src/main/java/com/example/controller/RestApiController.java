package com.example.controller;

import com.example.dto.PaymentCancelReq;
import com.example.dto.PaymentReq;
import com.example.dto.PaymentTransactionReq;
import com.example.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  @PostMapping("/payment")
  public ResponseEntity<?> payment(@RequestBody PaymentReq request){
    return new ResponseEntity<>(paymentService.payment(request), HttpStatus.OK);
  }

  @PostMapping("/cancel")
  public ResponseEntity<?> cancel(@RequestBody PaymentCancelReq request){
    return new ResponseEntity<>(paymentService.cancel(request), HttpStatus.OK);
  }

  @PostMapping("/transaction")
  public ResponseEntity<?> transaction(@RequestBody PaymentTransactionReq request){
    return new ResponseEntity<>(paymentService.transaction(request), HttpStatus.OK);
  }
}
