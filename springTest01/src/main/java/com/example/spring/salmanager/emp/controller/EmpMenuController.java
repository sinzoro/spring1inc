package com.example.spring.salmanager.emp.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import com.example.spring.salmanager.Board_Member;
import com.example.spring.salmanager.emp.service.EmpMenuService;
import com.example.spring.salmanager.payimf.service.PayimfService;


@Controller
public class EmpMenuController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmpMenuController.class);

	@Autowired
	private EmpMenuService empMenuService;

	
	private String PRE_VIEW_PATH = "/SalManager/emp/";

	@RequestMapping(value = "/emp_main.do")  					//����ȭ��
	public ModelAndView goEmpMenu(HttpServletRequest request) {

		HashMap<String, String> map = new HashMap<String, String>();
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("listNew", empMenuService.newEmpList(map));
		mv.addObject("countnew",empMenuService.newEmpList(map).size());
		
		mv.addObject("listExi", empMenuService.exiEmpList(map));
		mv.addObject("countexi",empMenuService.exiEmpList(map).size());
		
		mv.setViewName(PRE_VIEW_PATH + "emp_main");
		return mv;

	}


	// �ϱ�++++++++++++++++++++++++++++++++++++++++++++++++++++
	@RequestMapping(value = "/new_empcode.do", method = RequestMethod.GET)	//emp_main -> emp_newsali(üũ�� �ű԰�� �ο��� ��Ÿ���ִ� ��)
	public ModelAndView new_emp(@RequestParam HashMap<String, Object> params, Model model) throws Exception {

		ModelAndView mv = new ModelAndView();
		//System.out.println("map : "+params);
		
		mv.addObject("list", empMenuService.checkbox_Choice(params));
		mv.addObject("count",empMenuService.checkbox_Choice(params).size());
		
		List<HashMap<String, String>> aList = empMenuService.getAllowanceData();
		logger.debug("abc:::"+aList.get(0).get("scomNhCst"));
		//mv.addObject("aList",empMenuService.getAllowanceData());
		mv.addObject("aList",aList);
		
		mv.setViewName(PRE_VIEW_PATH + "emp_newsali");
		return mv;

	}
	
	@RequestMapping(value = "/exi_empcode.do", method = RequestMethod.GET)//emp_main -> emp_exisali(üũ�� ������� �ο��� ��Ÿ������)
	public ModelAndView exi_emp(@RequestParam HashMap<String, String> params, Model model) throws Exception {

		HashMap<String, String> map = new HashMap<String, String>();
		ModelAndView mv = new ModelAndView();
		System.out.println("map : "+params);
		
		
		mv.addObject("list",empMenuService.exi_checkbox_Choice(params));
		mv.addObject("count",empMenuService.exi_checkbox_Choice(params).size());
		
		mv.setViewName(PRE_VIEW_PATH + "emp_exisali");
		return mv;

	}
	
	@RequestMapping(value = "insert_sal_empcode.do",method = RequestMethod.POST)  //신규입력 post(방식)
	public ModelAndView i_sal_emp(@RequestParam HashMap<String, String> map) {
		ModelAndView mv = new ModelAndView();
		
		empMenuService.insert_newEmp_code(map);
		
		//System.out.println("insertsal map: "+map);
		/*mv.addObject("listNew", empMenuService.newEmpList(map));
		mv.addObject("count",empMenuService.newEmpList(map).size());
		mv.addObject("listExi", empMenuService.exiEmpList(map));
		*/
		mv.setViewName(PRE_VIEW_PATH + "mainMove");
		//empMenuService.insert_newEmp_code(map);
		return mv;
	}
	
	@RequestMapping(value = "update_sal_empcode.do",method = RequestMethod.POST)  //기존입력 post(방식)
	public ModelAndView u_sal_emp(@RequestParam HashMap<String, String> map) {
		ModelAndView mv = new ModelAndView();
		
		empMenuService.update_newEmp_code(map);
		//System.out.println("insertsal map: "+map);
		/*mv.addObject("listNew", empMenuService.newEmpList(map));
		mv.addObject("count",empMenuService.newEmpList(map).size());
		mv.addObject("listExi", empMenuService.exiEmpList(map));*/
		
		mv.setViewName(PRE_VIEW_PATH + "mainMove");
		//empMenuService.insert_newEmp_code(map);
		return mv;
	}




	/*
	 * @RequestMapping(value="1checkbox_Choice.do", method=RequestMethod.GET) public
	 * String checkboxTest(
	 * 
	 * @RequestParam MultiValueMap<String, Object> params, Model model) throws
	 * Exception{
	 * 
	 * HashMap<String , String> map = new HashMap<String , String>(); ModelAndView
	 * mv = new ModelAndView();
	 * 
	 * 
	 * for(int i=0; i<params.get("chk").size(); i++ ){ map.put(String.valueOf(i),
	 * params.get("chk").toString());//db �� ���� �ѷ��ִ°� }
	 * 
	 * 
	 * model.addAttribute("checkbox",boardService.checkbox_Choice(map));//�̰ɷ� db�� �ִ�
	 * ���� ������ �Ծ�. model.addAttribute("params",params);
	 * 
	 * return "board/checkbox_Delivery";
	 * 
	 * 
	 * }
	 */
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	

}
