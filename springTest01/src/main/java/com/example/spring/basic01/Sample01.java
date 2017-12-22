package com.example.spring.basic01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample01 {

   
   public static void main(String[] args) {
      
      String[] configLocations = {"basic01/sample01.xml"};
      //sample01.xml을 사용하기 위해서 만들어놓았어요. 내가 설정파일이 여러개면 여기에 넣어줘도 처리를 한다는거에요. 지금은 하나니까 하나했지, 만약 더 있었다면, ,하고 sample02.xml로 칠 수도 있을거에요. 
      
      ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
      //우리가 conf는 classpath로 설정을 했잖아요. 여기에 있는 경로만 집어넣어주시면, load시켜줘요.
      //applicationContext와 BeanPackage가 있는데, 이건, sample01.xml에 있는 bean정보. 를 applicationContext는 한꺼번에 new해서 만들어서 저장을 시켜놓아요. 
      //사용하지 않아도, 이 부분을 xml file을 읽자마자 new 정보를 저장해요. 그런데 이걸 미리 다 만들어놓고 필요할 때 사용하는게 fast loading이라고 해요. 용어는 필요없어요. 
      //FactoryBean이라는건, 이걸 내가 sender를 쓸 때 객체를 생성을 해요. lazy방법이에요. 늦은 생성이라고도 해요. bean정보에 있는 것을 읽자마자 바로, 객체정보를 만드는게 이거에요. 
      //이건 그러니까 바로 sender와 receiver를 읽어버린거죠. 
      
      Receiver receiver = (Receiver) context.getBean("receiver");
      //내가 사용한 id, name값에 대한 걸 요청하면.. 
      //xml에 있는 객체를 얻어올거에요. 
      
      System.out.println("send.time : "+receiver.getSendTime());
      //80이 나올거고
      System.out.println("send.time : "+receiver.getSender().isSender());
   }   //true가 나올거에요. 
}