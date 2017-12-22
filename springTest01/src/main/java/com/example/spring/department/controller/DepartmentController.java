package com.example.spring.department.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.department.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private String PRE_VIEW_PATH = "department/";
	
	@RequestMapping(value="departmentList.do")
	public ModelAndView departmentList(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		//ModelAndView mv = departmentService.departmentList(map);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", departmentService.departmentList(map));
		mv.setViewName(PRE_VIEW_PATH+"departmentList");
		
		return mv;
	}
	
	@RequestMapping(value="departmentInsert.do")
	public ModelAndView departmentInsert( HttpServletRequest request ) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("deptCode", "99");
		map.put("deptName", "테스트학과");
		map.put("deptEname", "dept of test");
		
		departmentService.departmentInsert(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(PRE_VIEW_PATH+"departmentInsertConfirm");
		
		return mv;
	}
	
	@RequestMapping(value="departmentUpdate.do")
	public ModelAndView departmentUpdate( HttpServletRequest request ) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("deptCode", "77");
		map.put("deptName", "테스트2학과");
		map.put("deptEname", "dept of test2");
		
		departmentService.departmentUpdate(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(PRE_VIEW_PATH+"departmentUpdateConfirm");
		
		return mv;
	}
	
}
