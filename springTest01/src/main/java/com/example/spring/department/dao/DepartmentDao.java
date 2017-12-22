package com.example.spring.department.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession; //myBatis로 바꼈지만 패키지명은 그대로 사용하고 있다
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("departmentDao") //다오에 해당되는 빈 아이디를 등록한다는 개념(아이디도정해줄수있다)
public class DepartmentDao {
	
	@Autowired // sqlSession에 자동으로 값을 넣어준다
	private SqlSession sqlSession; // 실질적으로 쿼리를 날리는 객체
	private String nameSpaceName = "department.";
	
	public List<HashMap<String, String>> departmentList(HashMap<String, String> map){
		
		List<HashMap<String, String>> list = this.sqlSession.selectList(nameSpaceName + "departmentList", map); //(쿼리id, 파라미터) 
		
		return list;
	}
	
	
	public void departmentInsert( HashMap<String, String> map ) {
		
		this.sqlSession.insert(nameSpaceName + "departmentInsert",map);
		
	}
	
	public void departmentUpdate( HashMap<String, String> map ) {
		
		this.sqlSession.update(nameSpaceName + "departmentUpdate",map);
		
	}


	
}
