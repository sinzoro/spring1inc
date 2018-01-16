package com.example.spring.salmanager.payimf.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.department.controller.DepartmentController;
import com.example.spring.salmanager.payimf.Service.PayimfService;

@Controller
public class PayimfController {
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private PayimfService payimfService;
	
	private String PRE_VIEW_PATH = "SalManager/payimf/";
	
	@RequestMapping(value="allowanceDataView.do")
	public ModelAndView allowanceDataView(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("list",payimfService.getAllowanceData());
		mv.setViewName(PRE_VIEW_PATH+"allowanceData");
		
		return mv;
	}
	
	@RequestMapping(value="allowanceDataInsert.do")
	public ModelAndView allowanceDataInsert(HttpServletRequest request) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		String nightTimeAllowance = request.getParameter("nightTimeAllowance");
		String carMaintenanceCost = request.getParameter("carMaintenanceCost");
		String dayTimeAllowance = request.getParameter("dayTimeAllowance");
		String foodCost = request.getParameter("foodCost");
		String lateness = request.getParameter("lateness");
		
		logger.debug("s:"+nightTimeAllowance );
		logger.debug("s:"+carMaintenanceCost );
		logger.debug("s:"+dayTimeAllowance );
		logger.debug("s:"+foodCost );
		logger.debug("s:"+lateness );
		
		map.put("nightTimeAllowance",nightTimeAllowance);
		map.put("carMaintenanceCost",carMaintenanceCost);
		map.put("dayTimeAllowance",dayTimeAllowance);
		map.put("foodCost",foodCost);
		map.put("lateness",lateness);
		
		//payimfService.allowanceDataInsert(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(PRE_VIEW_PATH+"allowanceData");
		
		return mv;
	}
	
}
