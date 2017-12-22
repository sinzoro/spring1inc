package com.example.spring.basic01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample01 {

   
   public static void main(String[] args) {
      
      String[] configLocations = {"basic01/sample01.xml"};
      //sample01.xml�� ����ϱ� ���ؼ� �������Ҿ��. ���� ���������� �������� ���⿡ �־��൵ ó���� �Ѵٴ°ſ���. ������ �ϳ��ϱ� �ϳ�����, ���� �� �־��ٸ�, ,�ϰ� sample02.xml�� ĥ ���� �����ſ���. 
      
      ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
      //�츮�� conf�� classpath�� ������ ���ݾƿ�. ���⿡ �ִ� ��θ� ����־��ֽø�, load�������.
      //applicationContext�� BeanPackage�� �ִµ�, �̰�, sample01.xml�� �ִ� bean����. �� applicationContext�� �Ѳ����� new�ؼ� ���� ������ ���ѳ��ƿ�. 
      //������� �ʾƵ�, �� �κ��� xml file�� ���ڸ��� new ������ �����ؿ�. �׷��� �̰� �̸� �� �������� �ʿ��� �� ����ϴ°� fast loading�̶�� �ؿ�. ���� �ʿ�����. 
      //FactoryBean�̶�°�, �̰� ���� sender�� �� �� ��ü�� ������ �ؿ�. lazy����̿���. ���� �����̶�� �ؿ�. bean������ �ִ� ���� ���ڸ��� �ٷ�, ��ü������ ����°� �̰ſ���. 
      //�̰� �׷��ϱ� �ٷ� sender�� receiver�� �о��������. 
      
      Receiver receiver = (Receiver) context.getBean("receiver");
      //���� ����� id, name���� ���� �� ��û�ϸ�.. 
      //xml�� �ִ� ��ü�� ���ðſ���. 
      
      System.out.println("send.time : "+receiver.getSendTime());
      //80�� ���ðŰ�
      System.out.println("send.time : "+receiver.getSender().isSender());
   }   //true�� ���ðſ���. 
}