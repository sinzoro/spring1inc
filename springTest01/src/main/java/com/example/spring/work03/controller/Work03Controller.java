package com.example.spring.work03.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class Work03Controller {

	
	
	
	
	
	
	
//	@RequestMapping(value="fileUploadTest.do")
//	public String fileUploadTest( MultipartHttpServletRequest request
//			,Model model ) {
//		
//		String rootUploadDir = "C:"+File.separator+"/Upload";
//		
//		File dir = new File( rootUploadDir + File.separator + "testfile" );
//		
//		if( !dir.exists() ) {
//			dir.mkdirs();
//		}
//				
//		Iterator<String> iterator = request.getFileNames();
//				
//		int fileLoop = 0;
//		String uploadFileName;
//		MultipartFile mFile = null;
//		String orgFileName = "";
//		String sysFileName = "";
//		
//		while( iterator.hasNext() ) {
//			fileLoop++;
//			
//			uploadFileName = iterator.next();
//			mFile = request.getFile(uploadFileName);
//			
//			orgFileName = mFile.getOriginalFilename();
//			
//			if( orgFileName != null && orgFileName.equals("") ) {
//				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMDDHHmmss-"+"");
//				Calendar calendar = Calendar.getInstance();
//				//sysFileName = 
//			}
//			
//			
//			
//			
//			
//		}
//		
//		
//				
//		return null;
//	}
	
}
