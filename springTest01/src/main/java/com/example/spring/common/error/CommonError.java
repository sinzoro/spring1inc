package com.example.spring.common.error;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


public class CommonError {
	private static final Logger logger = LoggerFactory.getLogger(CommonError.class);
	private final String VIEW_PATH_DIR = "/error/";
	
	@ExceptionHandler((Exception.class))
	//@ExceptionHandler((Exception.class, RuntimeException.class))
	public ModelAndView getCommonException(Exception e, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject( "errorMessage",e.getMessage() );
		mv.setViewName(VIEW_PATH_DIR + "error");
		
		return mv;
	}
	
	@ResponseStatus(value= HttpStatus.NOT_FOUND )	// 404
	public ModelAndView getFileNotFount(Exception e, HttpServletRequest request) {
		
		logger.debug("404 FileNotFount Error 발생");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("errorMessage","요청하신 파일을 찾을 수 없습니다.");
		mv.setViewName(VIEW_PATH_DIR + "error");
		
		return mv;
	}
	
	
}
