package com.example.spring.test.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Value("#{comm['dbms.username']}")
	String userName;

	public HashMap<String, Object> propertyRead(){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("username", userName);	// test
		
		return map;
	}
	
	
}
