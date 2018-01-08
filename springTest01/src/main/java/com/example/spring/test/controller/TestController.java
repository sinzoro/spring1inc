package com.example.spring.test.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.test.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService testService;

	String VIEW_PREFIX = "/test/";
	
	@RequestMapping(value="/propertyRead.do")
	public ModelAndView propertyRead( HttpServletRequest request, HttpServletResponse response ) {
		
		HashMap<String, Object> map = testService.propertyRead();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",map);	//map.get("username")	// test
		mv.setViewName(VIEW_PREFIX+"propertyRead");
		
		return mv;
	}
	
}
