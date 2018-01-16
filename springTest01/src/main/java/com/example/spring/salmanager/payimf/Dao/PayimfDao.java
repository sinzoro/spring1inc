package com.example.spring.salmanager.payimf.Dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("PayimfDao")
public class PayimfDao {

	@Autowired // sqlSession에 자동으로 값을 넣어준다
	private SqlSession sqlSession; // 실질적으로 쿼리를 날리는 객체
	private String nameSpaceName = "allowance.";
	
	public List<HashMap<String, String>> getAllowanceData(){
		List<HashMap<String, String>> list = null;
		
		list = this.sqlSession.selectList(nameSpaceName + "allowanceList");
		
		return list;
	}
	
	public int allowanceDataInsert(HashMap<String, String> map){
		List<HashMap<String, String>> list = null;
		
		int rsNum = 0;
		if( this.sqlSession.selectList(nameSpaceName + "allowanceInsert") == null ){
			rsNum = 1;
		}
		
		return rsNum;
	}
	
	
}

