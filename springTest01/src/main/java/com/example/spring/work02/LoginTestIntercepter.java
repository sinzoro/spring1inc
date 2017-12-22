package com.example.spring.work02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class LoginTestIntercepter extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginTestIntercepter.class);
	   
	   //컨트롤러가 실행되기전에 수행되는 코드
	   //return 값이 true : 요청된 컨트롤러 수행
	   //return 값이 false : 수행이 종료
	   //이곳에서 공통적으로 컨트롤러가 수행되기 전에 필수적으로 확인될 코드가 들어간다. 예를 들어 login
	   @Override
	   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{ //Object) throws Exception{ object뒤에는 안보인다.
	      logger.info("LoginTestIntercepter preHandle 진입");
	      
	      logger.info("id:"+request.getParameter("id"));
	      logger.info("pw:"+request.getParameter("pw"));
	      
	      //
	      String id = request.getParameter("id");
	      String pw = request.getParameter("pw");
	      if( id == null ) {
	    	  id = "";
	      }
	      if( pw == null ) {
	    	  pw = "";
	      }
	      
	      ///가정
	      String serverId = "ssss";
		  String serverPw = "1234";
		  String rsPath = "test";
		   
		  //get
		  String oriId = request.getParameter("id");
		  String oriPw = request.getParameter("pw");
		   
		  if( oriId.equals(serverId) && oriPw.equals(serverPw) ) {
			  request.getSession().setAttribute("id", oriId);
			  request.getSession().setAttribute("pw", oriPw);
			  request.getSession().setAttribute("rsPath", "/work02/loginTestRs");
		  }else {
			  request.getSession().setAttribute("id", "");
			  request.getSession().setAttribute("pw", "");
			  request.getSession().setAttribute("rsPath", "/work02/loginTest");
		  }
		  logger.info("id_2:"+request.getParameter("id"));
		  logger.info("pw_2:"+request.getParameter("pw"));
	      
	      return true;
	   }
	   
	   // view(jsp) 이동 전에 실행
	   // 컨트롤러에서 에러가 발생시에는 실행되지 않음
	   // request.setAttribute("",)
	   @Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			   ModelAndView modelAndView) throws Exception{
		   
		   logger.info("LoginTestIntercepter postHandle 진입");
		   
		   logger.info("id:"+request.getParameter("id"));
		   logger.info("pw:"+request.getParameter("pw"));

		   
		   //modelAndView.addObject("rsPath",rsPath);
		   
		   modelAndView.addObject("endData","postHandle Data");
		   
		   //request.setAttribute("endData","postHandle Data");
		   
		   super.postHandle(request, response, handler, modelAndView);
	   }
	   
	   
	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) throws Exception{
		   
		   logger.info("LoginTestIntercepter afterCompletion 진입");
		   
		   logger.info("id:"+request.getParameter("id"));
		   logger.info("pw:"+request.getParameter("pw"));
		   
		   //modelAndView.addObject("endData","postHandle Data");
		   
		   //request.setAttribute("endData","postHandle Data");
		   
		   super.afterCompletion(request, response, handler, ex);
		   
	   }
	
}

