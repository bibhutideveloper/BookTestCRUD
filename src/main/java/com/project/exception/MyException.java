package com.project.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class MyException {

	@ExceptionHandler(value=NoResourceFoundException.class)
	public String exceptionhandler(NoResourceFoundException e) {
		
		return "error-page";
	}
	
	
	@ExceptionHandler(value=ArithmeticException.class)
	public String exceptionhandler2(ArithmeticException e) {
		
		return "arith-page";
	}
	
}




