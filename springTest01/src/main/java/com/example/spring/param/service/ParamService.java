package com.example.spring.param.service;


import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.spring.param.controller.ParamController;




@Service
public class ParamService {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ParamController.class);
	public void paramView( HashMap<String, Object> params ) {
		
		logger.debug("paramView() 함수");
		
		
		
	}
	
	
}
