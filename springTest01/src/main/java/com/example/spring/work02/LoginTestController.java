package com.example.spring.work02;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginTestController {
	private static final Logger logger = LoggerFactory.getLogger(LoginTestController.class);
	
	   @RequestMapping(value="/testLogin/loginTest.do")
	   public String loginTest(HttpServletRequest request, Model model) throws Exception {
	      //logger.info("name:"+request.getParameter("name"));
	            
	      //이게 위치가 어디로 갈거냐, 
	      //return에
	      return "/work02/loginTest";
	   }
	   
	   @RequestMapping(value="/testLogin/loginTestRs.do")
	   public String loginTestRs(HttpServletRequest request, Model model) throws Exception {
	      logger.info("id(con):"+request.getParameter("id"));
	      logger.info("pw(con):"+request.getParameter("pw"));
	      logger.info("hobby(con):"+request.getParameter("hobby"));
	      
	      //
	      String rsPath = "/work02/loginTest";
	      logger.info("rsPath(con):"+rsPath );
	      rsPath = request.getSession().getAttribute("rsPath").toString();
		  
//	      if( rsPath.equals("") || rsPath == null ) {
//	    	  rsPath = "/work02/loginTest";
//	      }
		  
	      model.addAttribute( "id",request.getSession().getAttribute("id").toString() );
	      model.addAttribute( "pw",request.getSession().getAttribute("pw").toString() );
	      model.addAttribute( "hobby",request.getSession().getAttribute("hobby") );
	      

//	      model.addAttribute("email",request.getParameter("email"));
	      //이게 위치가 어디로 갈거냐, 
	      //return에
	      //return "/work02/loginTestRs";
	      return rsPath;
	   }
	
}
