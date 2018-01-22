<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- <script src="http://code.jquery.com/jquery-latest.min.js"></script> -->

<script src="/spring/resources/common/js/jquery-3.2.1.js"></script>
<script src="/spring/resources/common/js/jquery.form.js"></script>
<script src="/spring/resources/common/js/paging.js"></script>

</head>

<script type="text/javascript">
	function ajaxFormSubmit(url, formId){
		
		paging.ajaxFormSubmit(url, formId, function(rslt){
			console.log("결과데이타" + JSON.stringify(rslt));
			
			if(rslt.success == "true"){
				console.log("취미를 야구로 선택하셨습니다.");
			}else{
				console.log("취미를 야구로 선택하지 않으셨습니다.")
			}
		});
	}
	
</script>

<body>
	 <form id="frm">
	id : <input type="text" name="id" id="id">	
	name : <input type="text" name="name" id="name">	
	email : <input type="text" name="email" id="email">	
	<p> 취미 : <input type="checkbox" name="hobby" value="baseball">야구,
			<input type="checkbox" name="hobby" value="basketball">농구
	<p> 성별 : <input type="radio" name="sex" value="man">남자,
			<input type="radio" name="sex" value="woman">여자
	<p> 동물 : 
			<select name="selAnimal">
				<option value="dog">강아지</option>
				<option value="cow">소</option>
				<option value="cat">고양이</option>
			</select>		
	
	</form>
	<button type="button" onClick="ajaxFormSubmit('/spring/ajaxFormSubmit.ajax', 'frm')">입력</button>
</body>
</html>