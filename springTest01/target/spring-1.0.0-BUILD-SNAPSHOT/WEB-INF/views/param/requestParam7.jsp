<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script language="javascript"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<form:form commandName="mem">

	<p>id<input type="text" name="id" value="${mem.id }">
	<form:input path="id" />
	
	<p>name<input type="text" name="name" value="${mem.name }">
	<form:input path="name" />
	
	<p>email<input type="text" name="email" value="${mem.email }">
	<form:input path="email" />
	
	<p>
	hobby:
	<form:checkbox path="hobby" value="baseball" label="야구" />
	<form:checkbox path="hobby" value="reading" label="독서" />
	
	<p>
	hobby:
	<form:radiobutton path="sex" value="man" label="남자" />
	<form:radiobutton path="sex" value="woman" label="여자" />
	
	<p>
	selAnimal : 
	<form:select path="selAnimal">
		<form:options items="${animalMap }"></form:options>
	</form:select>
	

</form:form>




</body>
</html>