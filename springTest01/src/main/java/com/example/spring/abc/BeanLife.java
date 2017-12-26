package com.example.spring.abc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLife implements BeanNameAware, BeanFactoryAware, DisposableBean, InitializingBean {
	private String greeting;
	private String beanName;
	private BeanFactory beanFactory;
	
	public BeanLife() {
		System.out.println("(1) ���� ������ ����");
		
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("(2) Setter�� �޼ҵ� ����");
		
	}
	public void sayHello() {
		System.out.println(greeting+beanName+"!");
	}
	@Override
	public void setBeanName(String beanName) {
		System.out.println("(3) ���̸� ����");
		this.beanName = beanName;
		System.out.println(" -> " + beanName);
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) {
		System.out.println("(4) �� ���丮 ����");
		this.beanFactory = beanFactory;
		System.out.println(" -> " + beanFactory.getClass());
	}
	
	@Override
	public void afterPropertiesSet() throws Exception{
		System.out.println("(6) Property ���� �Ϸ�");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("����");
		
	}
	public void init() {
		System.out.println("(7) �ʱ�ȭ �޼ҵ带 ����");
	}
}
