package com.example.trace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraceStatus {
  private TraceInfo traceInfo;
  private Long startTimeMs;
  private String message;

}
