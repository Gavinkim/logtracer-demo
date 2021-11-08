package com.example.trace;

import org.junit.jupiter.api.Test;

class LogTraceComponentTest {

  @Test
  void start_end(){
    LogTraceComponent traceComponent = new LogTraceComponent();
    TraceStatus status = traceComponent.start("Test-01");
    traceComponent.end(status);
  }

  @Test
  void start_exception(){
    LogTraceComponent traceComponent = new LogTraceComponent();
    TraceStatus status = traceComponent.start("Test-01");
    traceComponent.exception(status, new IllegalAccessException());
  }
}