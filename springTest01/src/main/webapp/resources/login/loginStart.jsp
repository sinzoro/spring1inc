<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/spring/login/loginResult.do">
		제목 : <input type="text" name="subject"><br>
		내용 : <input type="text" name="content"><br>
		관심분야 : <input type="checkbox" name="attention" value="play">운동
				<input type="checkbox" name="attention" value="study">공부 <br>
		<input type="submit" value="보내기"> 	
	</form>
</body>
</html>