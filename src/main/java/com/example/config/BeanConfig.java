package com.example.config;

import com.example.trace.LogTrace;
import com.example.trace.LogTraceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean
  public LogTrace logTrace(){
    return new LogTraceService();
  }
}
