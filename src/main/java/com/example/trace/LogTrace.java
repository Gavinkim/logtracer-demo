package com.example.trace;

public interface LogTrace {

  TraceStatus start(String message);
  void end(TraceStatus status);
  void exception(TraceStatus status, Exception e);
}
