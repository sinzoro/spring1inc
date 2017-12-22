package com.example.spring.department.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.spring.department.dao.DepartmentDao;

@Service //서비스의 기능을 하고 있다고 정의 해놓는다고 보면 됨
public class DepartmentService {
	
	@Resource(name="departmentDao") // 특정이름의 자원으로 쓸때 아이디롤 정해서 가져다 쓴다
	private DepartmentDao departmentDao;
	
	/*private String PRE_VIEW_PATH = "/department/";
	public ModelAndView departmentList(HashMap<String, Object> map) {
		List<HashMap<String, Object>> list = departmentDao.departmentList(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName(PRE_VIEW_PATH+"departmentList");
		
		return mv;
	}*/
	
	
	public List departmentList(HashMap<String, String> map) {
		
		List<HashMap<String, String>> list = departmentDao.departmentList(map);
		
		return list;
	}
	
	public void departmentInsert(HashMap<String, String> map) {
		
		departmentDao.departmentInsert(map);

	}
	
public void departmentUpdate(HashMap<String, String> map) {
		
		departmentDao.departmentUpdate(map);
		
	}
	
}
