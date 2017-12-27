package com.example.spring.param.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring.entity.Member;
import com.example.spring.param.service.ParamService;

@Controller
public class ParamController{
   private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ParamController.class);
   
   
   @Autowired
   private ParamService paramService;

   
   @RequestMapping(value="/paramTest.do")
   public String paramTest(HttpServletRequest request, Model model) throws Exception {
      logger.info("name:"+request.getParameter("name"));
            
      //이게 위치가 어디로 갈거냐, 
      //return에
      return "/paramTest";
   }
   
   @RequestMapping(value="/requestParam.do", method=RequestMethod.GET)
   public String paramTest01(HttpServletRequest request, Model model) throws Exception {
      logger.info("name:"+request.getParameter("name"));
      
      
      model.addAttribute("id",request.getParameter("id"));
      model.addAttribute("name",request.getParameter("name"));
      model.addAttribute("email",request.getParameter("email"));
      //이게 위치가 어디로 갈거냐,
      //return에
      return "/param/requestParam";
   }
   
   //위에 있는걸 아래와같이 변형할 수 있다. 조금 더 간단하지. 지난번에 강사님께서 보여주셨던 페이지에서 비슷한 방식으로 접근하고 있는게 있지... 
   
   @RequestMapping(value="/requestParam2.do")
   public String paramTest02(
         @RequestParam(value="id") String id,
         @RequestParam(value="name") String name,
         @RequestParam(value="email", required=false) String email,
         @RequestParam(value="hobby", required=false) List<String> hobby,
         HttpServletRequest request, Model model) throws Exception {
      
      logger.info("name:"+request.getParameter("name"));
      model.addAttribute("id",id);
      model.addAttribute("name",name);
      model.addAttribute("email",email);
      model.addAttribute("hobby",hobby);
      //이게 위치가 어디로 갈거냐, 
      //return에
      
      for(String one: hobby) {
    	  logger.info("hobby:"+ one );
      }
      
      return "/param/requestParam2";
   }
   
   @RequestMapping(value="/requestParam3.do")
   public String paramTest03(Member mem, Model model) throws Exception {
	    logger.info("id:" + mem.getId());
		logger.info("name:" + mem.getName());
		logger.info("email:" + mem.getEmail());
      model.addAttribute("mem", mem );
      //이게 위치가 어디로 갈거냐, 
      //return에
      return "/param/requestParam3";
   }
   
   @RequestMapping(value="/requestParam4.do")
   public String paramTest04(
		   @ModelAttribute("mem") Member mem, Model model) throws Exception {
	   
	  logger.info("id:" + mem.getId() );
	  logger.info("name:" + mem.getName() );
	  logger.info("email:" + mem.getEmail() );
	  logger.info("hobby.length:" + mem.getHobby().length );
	  
	  for(int i=0; i<mem.getHobby().length;i++ ) {
		  logger.info( "hobby:"+mem.getHobby()[i] );
	  }
	  
	  for( String hobby: mem.getHobby() ) {
		  logger.info( "hobby:"+hobby );
	  }
      
      //이게 위치가 어디로 갈거냐, 
      //return에
      return "/param/requestParam4";
   }
   
   
   @ModelAttribute("animal")
	public ArrayList<String> getAnimalList(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("강아지");
		list.add("소");
		list.add("고양이");
		
		return list;
	}
   
   @ModelAttribute("animalMap")
   public Map<String, String> getAnimalMap(){
	   
	   Map<String, String> map = new HashMap<String, String>();
	   
	   map.put("dog", "개");
	   map.put("cow", "소");
	   map.put("cat", "고양이");
	   
	   return map;
   }	
   
   
   @RequestMapping(value="/requestParam5.do")
   public String paramTest05(
		   @RequestParam(value="id") String id,
	       @RequestParam(value="name") String name,
	       @RequestParam(value="email", required=false) String email,
	       @RequestParam(value="hobby", required=false) List<String> hobby,
		   @RequestParam HashMap<String, Object> params, 
		   Model model) throws Exception {
	   
	  logger.info("id:" + params.get("id") );
	  logger.info("name:" + params.get("name") );
	  logger.info("email:" + params.get("email") );
	  logger.info("hobby.length:" + params.get("hobby") );
	  
	  model.addAttribute("params",params);
	  model.addAttribute("id",id);
      model.addAttribute("name",name);
      model.addAttribute("email",email);
      model.addAttribute("hobby",hobby);
	  
      for(String one: hobby) {
    	  logger.info("hobby:"+ one );
      }
      
      return "/param/requestParam5";
   }
   
   @RequestMapping(value="/requestParam6.do")
   public String paramTest06(
		   
		   @RequestParam MultiValueMap<String, Object> params, 
		   Model model) throws Exception {
	   
	  logger.info("id:" +  params.get("id").get(0) );
	  logger.info("name:" + params.get("name").get(0) );
	  logger.info("email:" + params.get("email").get(0) );
	  logger.info("hobby:" + params.get("hobby").get(0) );
	  logger.info("hobby.size:" + params.get("hobby").size() );
	  
	  List<Object> hobbyList = params.get("hobby");
	  
	  for( int i=0; i< hobbyList.size();i++ ) {
		  logger.info( "hobby["+i+"]:"+ hobbyList.get(i) );
	  }
      
	  model.addAttribute("params",params);
      return "/param/requestParam6";
   }
   
   @RequestMapping(value="/requestParam7.do")
   public String paramTest07(
		   Member mem, 
		   Model model) throws Exception {
	   
	  logger.info("id:" + mem.getId() );
	  logger.info("name:" + mem.getName() );
	  logger.info("email:" + mem.getEmail() );
	  logger.info("hobby:" + mem.getHobby() );
	  logger.info("sex:" + mem.getSex() );
	  logger.info("selAnimal:" + mem.getSelAnimal() );
	  
	  
	  model.addAttribute("mem",mem);
      
	  
      return "/param/requestParam7";
   }
   
   
   @RequestMapping(value="/paramTest88.do")
   public String paramTest88(
		   
		   @RequestParam HashMap<String, Object> params, 
		   Model model) throws Exception {
	   
	  logger.info("id:" +  params.get("id") );
	  logger.info("name:" + params.get("name") );
	  logger.info("email:" + params.get("email") );
	  logger.info("hobby:" + params.get("hobby") );
	  logger.info("hobby.size:" + params.get("hobby") );
	  
	  
	  paramService.paramView(params);
	  
	  model.addAttribute("params",params);
	  
      return "/param/paramTest88";
   }
   
   
   
}

