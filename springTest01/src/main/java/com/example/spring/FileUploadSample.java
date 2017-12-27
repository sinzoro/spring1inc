package com.example.spring;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
public class FileUploadSample {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadSample.class);
	
	//테스트 페이지
	@RequestMapping(value="test345.do")
	public String test345() {
		
		return "testFileView";
	}
	
	@RequestMapping(value="fileUploadTest.do")
    public String fileUploadTest(MultipartHttpServletRequest request, Model model) {
        
        String rootUploadDir = "c:" +File.separator + "Upload3";
        
        logger.info("rootUploadDir -> " + rootUploadDir);
        
        File dir = new File(rootUploadDir + File.separator + "testfile");
 
        if(!dir.exists()) {//업로드 디렉토리가 존재하지 않으면 생성
            dir.mkdirs();
        }
        
        Iterator<String> iterator = request.getFileNames();    //업로드된 파일정보 수집
        
        int fileLoop = 0;
        String uploadFileName;
        MultipartFile mFile = null;
        String orgFileName = "";
        String sysFileName = "";
        
        ArrayList<String> list = new ArrayList<String>();
        
        while(iterator.hasNext()) {
            fileLoop++;
            
            uploadFileName = iterator.next();
            mFile = request.getFile(uploadFileName);
            
            orgFileName = mFile.getOriginalFilename();
            
            if(orgFileName != null && !orgFileName.equals("")) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMDDHHmmss-" + fileLoop);
                Calendar calendar = Calendar.getInstance();
                sysFileName = simpleDateFormat.format(calendar.getTime());
                
                logger.info("orgFileName -> " + orgFileName);
                logger.info("sysFileName -> " + sysFileName);
                
                try {
                    mFile.transferTo(new File(dir + File.separator + sysFileName));
                    
                    list.add("원본파일명 : " + orgFileName + ", 시스템파일명 : " + sysFileName);
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    list.add("파일올리는 중 에러 발생 " + e.toString());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    list.add("파일올리는 중 에러 발생 " + e.toString());
                }
            }
        }
        
        model.addAttribute("list", list);
        
        return "fileTest/fileResult";
    }

		
	//업로드 페이지
	@RequestMapping(value="fileUploadTest1.do")
	public String fileuploadTest1(  ) {
		
		return "fileUploadSample";
	}
	
	//파일업로드 MultipartFile
	@RequestMapping(value="fileUploadTest2.do")
	public String fileuploadTest2(MultipartHttpServletRequest request, Model model) {
		
		System.out.println( "abc1:"+ request.getParameter("name") );
		logger.info( "abc1:"+ request.getParameter("name") );
		
		String rootUploadDir = "c:" + File.separator+"Upload";
		File dir = new File(rootUploadDir + File.separator + "testfile");
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		System.out.println( "abc2:"+ request.getParameter("name") );
		logger.info( "abc2:"+ request.getParameter("name") );
		
		Iterator<String> iterator = request.getFileNames();
		int fileLoop = 0;
		String uploadFileName;
		MultipartFile mFile = null;
		String orgFileName = "";
		String sysFileName = "";
		ArrayList<String> list = new ArrayList<String>();
		
		while(iterator.hasNext()) {
			fileLoop++;
			uploadFileName = iterator.next();
			mFile = request.getFile(uploadFileName);
			
			orgFileName = mFile.getOriginalFilename();
			
			if(orgFileName != null && !orgFileName.equals("")) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMDDHHmmss" + fileLoop);
				Calendar calender = Calendar.getInstance();
				sysFileName = simpleDateFormat.format(calender.getTime());
				
				try {
					mFile.transferTo(new File(dir + File.separator + sysFileName)); // transferTo:실제 시스템파일명을 저장하는 메쏘드
					list.add("원본파일명 :" +orgFileName+ ", 시스템파일명 : " + sysFileName);
				} catch (Exception e) {
					list.add("파일올리던중 에러 발생");
				}
			}
			
		}
		
		model.addAttribute("list", list);
		
		return "fileUploadSample";
	}
	
	
}

