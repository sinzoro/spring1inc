package com.example.spring.login;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	//사용자�Y리 보는 결과값
	@RequestMapping(value = "/login/loginResult.do", method = RequestMethod.GET) 
	public String loginResult(@RequestParam HashMap<String, String> params,
							@RequestParam List<String> attention,
							Model model) {
		logger.info("subject : " + params.get("subject") +"//////////"+ " content : " + params.get("content"));
		logger.info("params : " + params);
		
		model.addAttribute("params", params);
		model.addAttribute("attention", attention);
		
		return "/login/loginResult";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET) 
	public String login(HttpServletRequest request, Model model) {
		logger.info("login.do 진입 : " + request.getRequestURI());
		return "/login/login";
	}
	
	@RequestMapping(value = "/setSession.do", method = RequestMethod.GET) 
	public ModelAndView setSession(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		logger.info("setSession.do 진입 : " + request.getSession().getAttribute("prvUrl"));
		logger.info("setSession id : " + request.getParameter("id"));
		logger.debug("setSession password : " + request.getParameter("password"));
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		request.getSession().setAttribute("id", id);
		request.getSession().setAttribute("password", password);
		return new ModelAndView("redirect:/resources/login/loginStart.jsp"); //사원리스트 페이지로 이동.
		//return new ModelAndView("redirect:"+request.getSession().getAttribute("prvUrl")); //사원리스트 페이지로 이동.
	}
}

