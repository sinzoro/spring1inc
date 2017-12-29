package com.example.spring.common.error;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
public class HttpErrorHandler {
	private static final Logger logger = LoggerFactory.getLogger(HttpErrorHandler.class);
	
	private final String VIEW_PATH_PREFIX = "/error/";
	
	
	@RequestMapping(value="/404")
	public String error404(HttpServletRequest request, HttpServletResponse response ) {
		
		logger.debug("404 에러발생  요청한 페이지가 존재하지 않음");
		
		response.setStatus( HttpServletResponse.SC_OK );
		
		return VIEW_PATH_PREFIX+"404";
	}
	
	
}





