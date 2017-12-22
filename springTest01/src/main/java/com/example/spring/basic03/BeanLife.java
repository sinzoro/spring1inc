package com.example.spring.basic03;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLife implements BeanNameAware, BeanFactoryAware, DisposableBean, InitializingBean{
   
   private String greeting;
   private String beanName;
   private BeanFactory beanFactory;
   
   public BeanLife() {
      System.out.println( "(1) 빈의 생성자 실행" );
   }
   public void setGreeting(String greeting) {
      this.greeting = greeting;
      System.out.println( "(2) Setter 메소드 실행" ); 
   }
   public void sayHello() {
      System.out.println( greeting + beanName + "!" );
   }
   @Override
   public void setBeanName( String beanName ) {
      System.out.println( "(3) 빈이름 설정" );
      this.beanName = beanName;
      System.out.println( " -> "+beanName );
   }
   
   @Override
   public void setBeanFactory(BeanFactory beanFactory) throws BeansException{
      System.out.println( "(4) 빈 팩토리 설정" );
      this.beanFactory = beanFactory;
      System.out.println( " -> " + beanFactory.getClass() );
   }
   @Override
   public void afterPropertiesSet() throws Exception {
      System.out.println( "(6) Property 설정 완료" );
   }
   @Override
   public void destroy() throws Exception {
      System.out.println( "종료" );
   }
   public void init() {
      System.out.println( "(7) 초기화 메소드를 실행" );
   }

}