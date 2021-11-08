package com.example.trace;

import java.util.UUID;
import lombok.Getter;

public class TraceInfo {

  @Getter
  private String id;
  @Getter
  private int level;


  public TraceInfo() {
    this.id = createId();
    this.level = level;
  }

  private TraceInfo(String id, int level) {
    this.id = id;
    this.level = level;
  }

  private String createId() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  public TraceInfo createNextId() {
    return new TraceInfo(id, level + 1);
  }

  public TraceInfo createPreviousId() {
    return new TraceInfo(id, level - 1);
  }

  public boolean isFirstLevel() {
    return level == 0;
  }

}
