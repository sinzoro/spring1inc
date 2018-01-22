<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="/spring/resources/common/js/paging.js"></script>

<script type="text/javascript">
  	
  	//upload파일 첨부 클릭시 div생성
  	function uploadFileAdd(){
  		var divObj = document.getElementById("submit_wrapper");
  		var uploadDiv = document.createElement("div");
  		uploadDiv.setAttribute("class", "upload_form_add");
  		uploadDiv.setAttribute("name", "divUpload");
  		
  		var findObj = document.createElement("input");
		findObj.type = "file";
		findObj.name = "fileName"+document.getElementsByName("divUpload").length;
		
		uploadDiv.appendChild(findObj);
  		divObj.appendChild(uploadDiv);
  	}
 	
  		
</script>
</head>
<body>
	
	<form action="/spring/fileuploadTest2.do" enctype="multipart/form-data" method="post">
		id : <input type="text" name="id"><br>
		name : <input type="text" name="name"><br>
		email : <input type="text" name="email"><br>
		취미 :<input type="text" name="hobby" value="baseball">
			<input type="text" name="hobby" value="레스링">
			<input type="text" name="hobby" value="reading"><br>
			<input type="checkBox" name="hobby1" value="baseball">야구
			<input type="checkBox" name="hobby1" value="reading">독서<br>
		성별 : <input type="radio" name="sex" value="man">남자
			<input type="radio" name="sex" value="woman">여자
			<br>
		동물 : 
			<select name="animal">
				<option value="dog">강아지</option>
				<option value="cow">소</option>
				<option value="cat">고양이</option>
			</select>
		<div id="submit_wrapper">
			<input type="button" class="left_btn" value="파일첨부" onClick="uploadFileAdd();" >
		</div>
		<input type="submit" value="파일업로드">
	</form>
</body>
</html>