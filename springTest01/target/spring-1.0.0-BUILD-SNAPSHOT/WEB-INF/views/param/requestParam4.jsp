<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script src="https://code.jquery.com/jquery-3.2.1.js">
<script language="javascript"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p> id : ${mem.id }
<p> name : ${mem.name }
<p> email : ${mem.email }
<p> hobby : <br>
	
	<c:forEach var="arr" items="${mem.hobby}">
		<c:out value="${arr }" /><br>
	</c:forEach>
	
	
	<c:forEach var="animal" items="${animal}">
		<c:out value="${animal }" /><br>
	</c:forEach>



requestparam에서 내가 값을 받으려고 하면, 이렇게 하면 돼요.
</body>
</html>