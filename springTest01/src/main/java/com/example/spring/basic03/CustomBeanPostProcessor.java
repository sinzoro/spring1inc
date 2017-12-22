package com.example.spring.basic03;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor{

   @Override
   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      System.out.println( "(5) 초기화 전의 변에 대한 처리를 실행 : " + beanName );
      return bean;
   }

   @Override
   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
      System.out.println( "(8) 초기화 후의 변에 대한 처리를 실행 : " + beanName );
      return bean;
   }
   
}