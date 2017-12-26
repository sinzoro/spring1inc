package com.example.spring.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	//컨트롤러가 실행되기 전에 수행되는 코드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception{
		logger.info("loginInterceptor 진입 : ");
		HttpSession httpSession = request.getSession();
		StringBuffer prvUrl = request.getRequestURL();
		if(httpSession.getAttribute("id") == null) {
			httpSession.setAttribute("prvUrl", prvUrl);
			response.sendRedirect("/spring/login.do");
			return false;
		}else {
			return true; //false이면 컨트롤러로 진입이 안된다
		}
	}
	
	//뷰(jsp) 이동 바로전에 실행
	//컨트롤러에서 에러가 발생시에는 실행되지 않는다
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		logger.info("loginInterceptor postHandle 진입 : " + request.getParameter("subject"));
		modelAndView.addObject("endData", "postHandle Data");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	//jsp까지 보두 보여준 후에 실행된다
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("loginInterceptor afterCompletion 진입 : " + request.getParameter("subject"));
		super.afterCompletion(request, response, handler, ex);
	}
}