package com.example.spring.salmanager.payimf.service;

import java.util.HashMap;
import java.util.List;

import com.example.spring.salmanager.payimf.common.CommaChange;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.spring.salmanager.payimf.dao.PayimfDao;

@Service
public class PayimfService {

	@Resource(name="PayimfDao") // 특정이름의 자원으로 쓸때 아이디롤 정해서 가져다 쓴다
	private PayimfDao payimfDao;
	
	public List<HashMap<String, String>> getAllowanceData(){
		
		List<HashMap<String, String>> list = payimfDao.getAllowanceData();
		
		HashMap<String, String> map = list.get(0);	///
		
		CommaChange commaChange = new CommaChange();

		for( String key : map.keySet() ){

            if( key.equals("salType") || key.equals("scomYymm") )
            	continue;
            
            System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
            
            int result = Integer.parseInt( map.get(key) );
            String str = new java.text.DecimalFormat("#,###").format(result).toString();
            map.put( key, str );
            System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );            

        }
		
		return list;
	}
	
	public HashMap<String, String> allowanceDataInsert(HashMap<String, String> map){
		
		map.put("divSal", "basic");
		
		for( String key : map.keySet() ){

            System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
            map.put(key, map.get(key).replace(",","") );
            System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );            

        }

		
		int rsNum = payimfDao.allowanceDataInsert(map);
		if( rsNum == 1) {
			map = getAllowanceData().get(0);
		}
		return map;
	}
	
	
}
