<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/spring/requestParam4.do">
<p>id<input type="text" name="id">
<p>name<input type="text" name="name">
<p>email<input type="text" name="email">
<p>hobby : <input type="checkbox" name="hobby" value="baseball">야구,
			<input type="checkbox" name="hobby" value="reading">독서
			
<p><input type="submit" value="서버보내기">
</form>
</body>
</html>