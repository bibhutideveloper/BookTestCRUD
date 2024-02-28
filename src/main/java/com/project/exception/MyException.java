package com.project.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class MyException {


	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler1(Exception e) {
		
		return "exception-msg";
	}
	
	@ExceptionHandler(value=ArithmeticException.class)
	public String exceptionHandler2(ArithmeticException e) {
		
		return "arith-page";
	}
	
	@ExceptionHandler(value=NoResourceFoundException.class)
	public String exceptionHandler3(NoResourceFoundException e) {
		
		return "error-page";
	}
}




