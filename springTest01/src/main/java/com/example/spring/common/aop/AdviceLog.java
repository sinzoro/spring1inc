package com.example.spring.common.aop;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
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
	}//beforeTest2
	
	//@After("execution (* com.example.spring.param.service.oneFunction..*.*(..))")
	@After("execution (* com.example.spring.param.service..*.*(..))")
	public void afterTest1(JoinPoint joinPoint) {
		
		Signature method = joinPoint.getSignature();
		
		String methodName = method.getName();
		logger.debug(" 함수명 @After 에러 발생~~~ : " + methodName );

		
		Object[] params = joinPoint.getArgs();
		
//		for(Object param : params ) {
//			
//			if(param instanceof HashMap ) {
//				HashMap<String, Object> map = (HashMap)param;
//				
//				for(String key : map.keySet() ) {
//					logger.debug("key : " + key + ", value : " + map.get(key) );
//				}//for
//			}//if
//		}//for
	}//afterTest1
	
	// * 모든값을 의미
	// .. 1개이상을 의미
	// execution "[접근지정자  - 생략가능] [리턴타입] [클래스명] [함수이름] ([파라미터])"
	// ex 1) com.example.spring 패키지네에 파라미터가 존재하지 않는 함수
	//		execution("* com.example.sprig.*.*()");
	
	// ex 2) com.example.spring 하부 패키지에서 파라미터가 1개 이상인 함수
	// 		execution("* com.example.spring..*.*(..)");
	
	// ex 3) com.example.spring.service 패키지네에 함수명이 paramView 이면서 파라미터가 1개 이상인것
	//		excution("* com.example.spring.service.paramView(..)");

	// ex 4) param으로 시작되는 함수중에 파라미터 갯수가 1개 이상인것에서 적음
	//		execution("* param*(..) ");
	
	// ex 5) param으로 시작되는 함수중에 파라미터 갯수가 1개 인것
	//		excution("* param*(*) ");
	
	// ex 6) param으로 시작되는 함수중에 파라미터 갯수가 2개 인것
	//		excution("* param*(*,*) ");
	
	// ex 7) param으로 시작되는 함수중에 첫번째 파라미터 테이터 타입이 스트링이면서 갯수가 2개 인것
	//		excution("* param*(String,*) ");
	
	//		excution("* param*(int,..) ");
	
	//		excution(" *list(..) ");
	
	
	
	
	

}



