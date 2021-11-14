package com.example.service;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * https://www.youtube.com/watch?v=WQXXrHhLH-M
 */
public class FunctionalExample {

  //functional interface 제네릭으로 사용
  private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, FunctionalEx01<T1, T2,T3, String> function) {
    System.out.println(function.apply(t1,t2,t3));
  }

  public static void main(String[] args) {

    //기존 자바 제공
    Function<Integer, String> numToString = (num) -> String.format("my number is %s", num);
    System.out.println(numToString.apply(10000));

    //functionalex01
    println(1,2,3,(i1, i2,i3)->String.valueOf(i1+i2+i3));


    FunctionalEx01<Integer,Integer, Integer,String> functionalEx01 = (i1,i2,i3) -> String.format("%s",i1+i2+i3);
    System.out.println(functionalEx01.apply(1,2,3));


    //bigdecimal functional interface
    BIgDecimalToCurrency bIgDecimalToCurrency = bd -> "$" +bd.toString();
    System.out.println(bIgDecimalToCurrency.toCurrency(new BigDecimal("120.00")));


  }

}
