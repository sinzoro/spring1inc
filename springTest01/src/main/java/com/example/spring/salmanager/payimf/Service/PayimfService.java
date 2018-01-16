package com.example.spring.salmanager.payimf.Service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.spring.salmanager.payimf.Dao.PayimfDao;

@Service
public class PayimfService {

	@Resource(name="PayimfDao") // 특정이름의 자원으로 쓸때 아이디롤 정해서 가져다 쓴다
	private PayimfDao payimfDao;
	
	public List<HashMap<String, String>> getAllowanceData(){
		
		List<HashMap<String, String>> list = payimfDao.getAllowanceData();
		
		return list;
	}
	
	public int allowanceDataInsert(HashMap<String, String> map){
		
		int rsNum = payimfDao.allowanceDataInsert(map);
		
		return 0;
	}
	
	
}