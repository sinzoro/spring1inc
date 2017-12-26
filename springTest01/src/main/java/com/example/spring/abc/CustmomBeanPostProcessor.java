package com.example.spring.abc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustmomBeanPostProcessor implements BeanPostProcessor{
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
		System.out.println("(5)�ʱ�ȭ ���� �� ���� ó���� ���� : " + beanName);
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
		System.out.println("(8) �ʱ�ȭ ���� �� ���� ó���� ���� : " + beanName);
		return bean;
	}

}
