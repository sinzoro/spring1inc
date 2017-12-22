<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/spring/testLogin/loginTestRs.do">
	
	<p>id<input type="text" name="id">
	<p>pw<input type="text" name="pw">
	<p>관심분야 : <input type="checkbox" name="hobby" value="play">운동,
			<input type="checkbox" name="hobby" value="study">공부

	<p><input type="submit" value="서버보내기">
	
</form>

</body>
</html>