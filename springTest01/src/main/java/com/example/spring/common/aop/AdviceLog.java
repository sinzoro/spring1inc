package com.example.spring.common.aop;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.spring.common.CommonFilter;

@Aspect
public class AdviceLog {
	private static final Logger logger = LoggerFactory.getLogger(CommonFilter.class);
	
	//정상적으로 실행되어야될 비지니스로직 메소드
	//@Around("within(com.example.spring..*)")
	public Object processTimeCheck( ProceedingJoinPoint proceedingJoinPoint ) {
		
		String name = proceedingJoinPoint.getSignature().toLongString();
		logger.debug( name + " is start >>> " );
		long startTime = System.currentTimeMillis();
		Object obj = null;
		
		try {
			obj = proceedingJoinPoint.proceed();
			return obj;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			long endTime = System.currentTimeMillis();
			logger.debug( name + " is finish >>> " );
			logger.debug( name + " 실행경과시간 : " + ( endTime - startTime ) );
		}
		
		
		return obj;
	}
	
	//spring에서 비지니스로직 함수, 매개변수, 정보를 가지고 있는개체
	@Before("within(com.example.spring..*)")
	public void beforeTest(JoinPoint joinPoint) {
		
		Signature method = joinPoint.getSignature();
		
		String methodName = method.getName();
		logger.debug(" 함수명 @Before : " + methodName );
		
		Object[] params = joinPoint.getArgs();

	}
	
	//@Before("within(com.example.spring.param.service.*)")
	public void beforeTest2(JoinPoint joinPoint) {
		
		Signature method = joinPoint.getSignature();
		
		String methodName = method.getName();
		logger.debug(" 함수명 : " + methodName );
		
		Object[] params = joinPoint.getArgs();
		
		for(Object param : params ) {
			
			if(param instanceof HashMap ) {
				HashMap<String, Object> map = (HashMap)param;
				
				for(String key : map.keySet() ) {
					logger.debug("key : " + key + ", value : " + map.get(key) );
				}//for
				
			}//if
			
		}//for
		
		
		
		
	}
	
	
	
	
	
}

