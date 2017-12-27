package com.example.spring.department.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.department.dao.DepartmentDao;

@Service //서비스의 기능을 하고 있다고 정의 해놓는다고 보면 됨
public class DepartmentService {
	private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);
	
	@Resource(name="departmentDao") // 특정이름의 자원으로 쓸때 아이디롤 정해서 가져다 쓴다
	private DepartmentDao departmentDao;
	
	private String PRE_VIEW_PATH = "/department/";
	
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
	
//파일 업로드
	public void fileUpload(HashMap<String, Object> map, List<MultipartFile> fileList){
		
		String rootPath = "c:" + File.separator +"Upload3";
		String uploadPath = rootPath + File.separator + "testfile";
		int fileLoop = 0;
		String orgFileName = "";
		String sysFileName = "";
		
		if(fileList !=null && fileList.size()>0) {
		
			Calendar calendar = Calendar.getInstance();
			
			
			for(MultipartFile file : fileList) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss-"+ fileLoop);
				orgFileName = file.getOriginalFilename();
				if(orgFileName !=null && orgFileName.equals("")) {
					sysFileName = simpleDateFormat.format(calendar.getTime());
					
					
					try {
						file.transferTo(new File(uploadPath + File.separator + sysFileName));

					}catch (Exception e) {
					
					}
					
					fileLoop++;
					
					logger.debug("원본파일명 : " + orgFileName + ", 시스템파일명" + sysFileName);
					
				}//if
			}//for
		}//if
	}//fileUpload
	
}//class
