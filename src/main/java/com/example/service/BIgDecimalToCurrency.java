package com.example.service;

import java.math.BigDecimal;

@FunctionalInterface
public interface BIgDecimalToCurrency {
  String toCurrency(BigDecimal value);
}
