<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/spring/requestParam88.do">
<p>id<input type="text" name="id">
<p>name<input type="text" name="name">
<p>email<input type="text" name="email">
<p>hobby : <input type="checkbox" name="hobby" value="baseball">야구,
			<input type="checkbox" name="hobby" value="reading">독서
<p>성 별  : <input type="radio" name="sex" value="man">남자,
			<input type="radio" name="sex" value="woman">여자			

<p>동 물 : 
		<select name="selAnimal">
			<option value="dog">개</option>
			<option value="cow">소</option>
			<option value="cat">고양이</option>
		</select>

<p><input type="submit" value="서버보내기">
</form>
</body>
</html>