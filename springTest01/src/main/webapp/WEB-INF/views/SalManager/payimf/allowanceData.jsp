<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
	
	function AllowanceSave(){
		alert("Allowance");
		
		var allowanceDataFrm = document.getElementById("allowanceDataFrm");
		//alert(allowanceDataFrm);
		allowanceDataFrm.action = "${pageContext.request.contextPath}/allowanceDataInsert.do";
		allowanceDataFrm.submit();
		
	}
	
</script>

</head>
<body>


	<form action="" name="allowanceDataFrm" id="allowanceDataFrm" method="post">
		야근 시간당수당 <input type="text" name="nightTimeAllowance" value="${list.get(0).dept_code }" > 
		차량 유지비  <input type="text" name="carMaintenanceCost" >
		<br>
		주간 시간당수당 <input type="text" name="dayTimeAllowance"> 
		식대  <input type="text" name="foodCost" >
		<br>
		지각 <input type="text" name="lateness">
		<p>
		<input type="button" value="저장" onclick="AllowanceSave()">
	</form>
	
	
</body>
</html>