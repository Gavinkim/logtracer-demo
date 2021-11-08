package com.example.trace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogTraceComponent {

  private static final String START_PREFIX = "-->";
  private static final String COMPLETE_PREFIX = "<--";
  private static final String EX_PREFIX = "<X-";

  public TraceStatus start(String message) {
    TraceInfo traceInfo = new TraceInfo();
    Long startTimeMs = System.currentTimeMillis();
    log.info("[{}] {}{}", traceInfo.getId(), addSpace(START_PREFIX, traceInfo.getLevel()), message);
    return new TraceStatus(traceInfo, startTimeMs, message);
  }

  public void end(TraceStatus status) {
    complete(status, null);
  }

  public void exception(TraceStatus status, Exception e) {
    complete(status, e);
  }

  private void complete(TraceStatus status, Exception e) {
    Long stopTimeMs = System.currentTimeMillis();
    long resultTimeMs = stopTimeMs - status.getStartTimeMs();
    TraceInfo traceInfo = status.getTraceInfo();
    if (e == null) {
      log.info("[{}] {}{} time={}ms", traceInfo.getId(),
          addSpace(COMPLETE_PREFIX, traceInfo.getLevel()), status.getMessage(), resultTimeMs);
    } else {
      log.info("[{}] {}{} time={}ms ex={}", traceInfo.getId(),
          addSpace(EX_PREFIX, traceInfo.getLevel()), status.getMessage(), resultTimeMs,
          e.toString());
    }
  }

  private static String addSpace(String prefix, int level) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < level; i++) {
      sb.append((i == level - 1) ? "|" + prefix : "|   ");
    }
    return sb.toString();
  }

}
