package com.deepanshu.OnlineShopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException()
	{
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not Constructed");
		
		mv.addObject("errorDescription", "The Page you are looking for is not Available now!");
		
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFoundException()
	{
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product Not Available!");
		
		mv.addObject("errorDescription", "The Product you are looking for is not Available right now!");
		
		mv.addObject("title", "Product Unavailable");
		
		return mv;
	}

}
