package com.sist.web.commons;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.io.*;
// 공통 예외처리
@RestControllerAdvice
public class CommonsException {
   @ExceptionHandler(Exception.class)
   public void exception(Exception e)
   {
	   System.out.println("=============== error 발생(Exception) =============");
	   e.printStackTrace();
	   System.out.println("=======================================");
   }
   @ExceptionHandler(IOException.class)
   public void ioExcetion(IOException e)
   {
	   System.out.println("=============== error 발생(IOExceptionn) =============");
	   e.printStackTrace();
	   System.out.println("=======================================");
   }
}