<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td valign=top>
			+++++ test01End.do 
			<form action="/spring/test01End.do">
				id : <input type="text" name="id"><br>
				name : <input type="text" name="name"><br>
				email : <input type="text" name="email"><br>
				<input type="submit" value="전송">
			</form>
			<br><br><br>
			
			+++++ test02End.do : id가 없으면 현재 페이지로 다시 와라
			<form action="/spring/test02End.do">
				id : <input type="text" name="id"><br>
				name : <input type="text" name="name"><br>
				email : <input type="text" name="email"><br>
				취미 :<input type="text" name="hobby" value="baseball">
					<input type="text" name="hobby" value="reading"><br>
				<input type="submit" value="전송">
			</form>
			<br><br><br>
			
			+++++ test03End.do (Member클래스사용)
			<form action="/spring/test03End.do">
				id : <input type="text" name="id"><br>
				name : <input type="text" name="name"><br>
				email : <input type="text" name="email"><br>
				<input type="submit" value="전송">
			</form>
			<br><br><br>
			
			+++++ test04End.do (Member클래스사용)
			<form action="/spring/test04End.do">
				id : <input type="text" name="id"><br>
				name : <input type="text" name="name"><br>
				email : <input type="text" name="email"><br>
				<input type="submit" value="전송">
			</form>
			<br><br><br>
			
			+++++ test05End.do (Member클래스사용&)
			<form action="/spring/test05End.do">
				id : <input type="text" name="id"><br>
				name : <input type="text" name="name"><br>
				email : <input type="text" name="email"><br>
				취미 :<input type="text" name="hobby" value="baseball">
					<input type="text" name="hobby" value="reading"><br>
				<input type="submit" value="전송">
			</form>
			<br><br><br>
		</td>
		<td width=50></td>
		<td  valign=top>
			+++++ test06End.do (Member클래스사용&)
			<form action="/spring/test06End.do">
				id : <input type="text" name="id"><br>
				name : <input type="text" name="name"><br>
				email : <input type="text" name="email"><br>
				취미 :<input type="text" name="hobby" value="baseball">
					<input type="text" name="hobby" value="reading"><br>
				<input type="submit" value="전송">
			</form>
			
			<br><br><br>
			+++++ test07End.do (Member클래스사용&)
			<form action="/spring/test07End.do">
				id : <input type="text" name="id"><br>
				name : <input type="text" name="name"><br>
				email : <input type="text" name="email"><br>
				취미 :<input type="text" name="hobby" value="baseball">
					<input type="text" name="hobby" value="레스링">
					<input type="text" name="hobby" value="reading"><br>
				<input type="submit" value="전송">
			</form>
			
			<br><br><br>
			+++++ test08End.do (Member클래스사용&)
			<form action="/spring/test08End.do">
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
				<input type="submit" value="전송">
			</form>
		</td>
	</tr>
</table>	
</body>
</html>