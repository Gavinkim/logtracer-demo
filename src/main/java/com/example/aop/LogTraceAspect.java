package com.example.aop;

import com.example.trace.LogTrace;
import com.example.trace.TraceStatus;
import java.lang.reflect.Method;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LogTraceAspect {

  private final LogTrace logTrace;

  @Pointcut("execution(* com.example..*(..))")
  private void pointCut() {

  }

  @Pointcut("@annotation(com.example.annotation.LogTrace)")
  private void logTrace(){

  }


  @Around("pointCut() && logTrace()")
  public void around(ProceedingJoinPoint joinPoint) throws Throwable {
    TraceStatus status = null;
    try {
      //실행 전
      MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
      Method method = methodSignature.getMethod();
      status = logTrace.start(method.toString());

      //로직 실행
      Object result = joinPoint.proceed();

      //실행 후
      logTrace.end(status);
    } catch (Exception e) {
      logTrace.exception(status, e);
    }
  }

}
