package com.example.spring.department.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.department.service.DepartmentService;

@Controller
public class DepartmentController {
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	private String PRE_VIEW_PATH = "department/";
	
	@RequestMapping(value="departmentList.do")
	public ModelAndView departmentList(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		
//		map.put("deptCode", "10"); // dept코드가 10인것만 검색할것임
//		ModelAndView mv = departmentService.departmentList(map);
		
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
		//mv.setViewName(PRE_VIEW_PATH + "insertConfirm");
		
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
	
	@RequestMapping(value="ajaxFormSubmit.ajax")
	public @ResponseBody HashMap<String, String>ajaxFormSubmit(
			@RequestParam HashMap<String, String> map
			,@RequestParam(value="hobby") List<String> hobbyList
			){
		map.put("success", "false");//hobby의 baseball이 false이면
		
		for(String hobby : hobbyList) {//for문을 돌려 
			if(hobby.equals("baseball")) { 
				map.put("success", "true");// true로 바꾸겠다.
				break;
			}
		}
		return map;
	}
	
	//파일 업로드
	@RequestMapping(value="fileUploadTest5.do")
	public String fileUploadTest(MultipartHttpServletRequest request
			, Model model) {
		
		/*String rootUploadDir = "c:/Upload";*/
		String rootUploadDir = "c:"+File.separator+"Upload3"; // 이 위치에 파일을 저장하겠다(C:\Upload\testfile //////  File.separator는 C:와 Upload 사이의 "\") 
		
		File dir = new File(rootUploadDir + File.separator + "testfile");
		
		if(!dir.exists()) {//업로드 디렉토리가 존재하지 않는다면
			dir.mkdirs(); //만들겠다
		}
		
		Iterator<String> iterator = request.getFileNames(); //업로드된 파일정보 수집
		
		int fileLoop = 0;
		String uploadFileName;
		MultipartFile mFile = null;
		String orgFileName="";
		String sysFileName="";
		
		
		ArrayList<String> list = new ArrayList<String>();// 저장된 정보저장된것 확인위해 만듬
		
		
		while(iterator.hasNext()) {// iterator로 올린 파일정보중에서 파일 찾기
			fileLoop++;
			
			uploadFileName = iterator.next();// 파일이름을 하나하나씩 가져옴
			mFile = request.getFile(uploadFileName);// 멀티파트에 저장되어있는 uploadFileName의 파일객체의 정보를 가져옴
			
			orgFileName =mFile.getOriginalFilename();//  uploadFileName의 파일객체의 정보에서 OriginalFilename 가져오기
			
			if(orgFileName !=null && !orgFileName.equals("")) { //orgFileName이 있으면 
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMDDHHmmss-" + fileLoop); //fileLoop를 돌면서 yyyyMMDDHHmmss 형식으로 업로드 파일이름 생성하기
				Calendar calendar = Calendar.getInstance();
				sysFileName = simpleDateFormat.format(calendar.getTime()); //simpleDateFormat의 format을 yyyyMMDDHHmmss 의 형식으로 파일은 만들어 sysFileName에 담겠다.
				
				try {
					mFile.transferTo(new File(dir + File.separator + sysFileName));// 시스템 파일명으로 변환해서 저장
					list.add("원본파일명 : " + orgFileName + ", 시스템파일명 : " + sysFileName);//
					
				}catch (Exception e) {
					list.add("파일 올리는 중 에러발생!!!");
				}
			}//if
		}//while
		
		
		model.addAttribute("list", list); //list란 이름으로 저장
		
		return "depart/departmentList";
	}
	
	//파일 업로드 실행
	@RequestMapping(value="/fileUpload.do")
	public String fileUpload(
			@RequestParam HashMap<String, Object> map
			,@RequestParam(value="hobby") List<String> hobby
			 ,@RequestParam(value="file1") List<MultipartFile> fileList
			  ,MultipartHttpServletRequest requset){
		
				logger.debug("서버로 전달된 값 : " +  map);
			
		for(String one: hobby) {
			logger.debug("서버로 취미결과 : " +  one);
		}
		
		departmentService.fileUpload(map, fileList);
		
		
		return null;
	}
	
	
	//에러테스트 함수
	@RequestMapping(value="/errorTest.do")
	public String errorTest(HttpServletRequest request, Model mode) throws Exception {
		
		logger.debug("/errorTest.do 진입");
		
		if(1==1) {
			throw new Exception("errorTest.do 에서 에러발생");
		}
		
		return null;
	}
	
}//class
