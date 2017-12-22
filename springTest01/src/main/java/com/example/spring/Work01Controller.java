package com.example.spring;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class Work01Controller extends AbstractController {

	
//	private String test111;
//	
//	public void setTestValue(String test111) {
//		this.test111 = test111;
//	}
	
	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("testValue","");
		mv.addObject("abc","abc111");
		mv.setViewName("work001");
		
		
		return mv;
	}
	
	
}
