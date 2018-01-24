<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/allowance.css" type="text/css" /> --%>
<link rel="stylesheet" href="resources/common/css/allowance.css" type="text/css" />

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>

<script>
	
	function AllowanceSaveAjax(){
		//alert("Allowance");
		
		//var allowanceDataFrm = document.getElementById("allowanceDataFrm");
		//alert(allowanceDataFrm);
		//allowanceDataFrm.action = "${pageContext.request.contextPath}/allowanceDataInsert.do";
		//allowanceDataFrm.submit();
		
		console.log("before start");
		$("#allowanceDataFrm").ajaxForm({
			async : false,
			cache:false,
			type:"POST", //전송방식을 정하는 메쏘드
			url	:"${pageContext.request.contextPath}/allowanceDataInsert.do", //보낼페이지
			
			dataType:"JSON", 
			beforeSend:function(){
				console.log("beforeSend");
			},
			
			success: function(data){
				console.log("성공 data : " + JSON.stringify(data));
				
				$("#scomHhCst").val(data.scomHhCst);
				$("#scomNhCst").val(data.scomNhCst);
				$("#scomLhCst").val(data.scomLhCst);
				$("#scomElhCst").val(data.scomElhCst);
				$("#sempCmc").val(data.sempCmc);
				//alert( $("#sempCmc").val() );
			},
			error: function(xhr, status, error){
				console.log("실패");
				//console.log("xhr:"+JSON.stringify(xhr));
				//console.log("status:"+status);
				//console.log("error:"+error);
			},
			complete: function(event, request, settings){ //마지막에 무조건 실행
				console.log("완료");
				//console.log("event : " + JSON.stringify(event));
				//console.log("request : " + request);
				//console.log("settings : " + settings);
			}

		}).submit();
		
	}
	
	// 숫자만 입력, 콤마찍기
	//콤마찍기
	function comma(str) {
	    str = String(str);
	    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	}
	//콤마풀기
	function uncomma(str) {
	    str = String(str);
	    return str.replace(/[^\d]+/g, '');
	}
	function onlyNumber(obj) {
		$(obj).keyup(function(){
			obj.value = comma(uncomma(obj.value));
	    	$(obj).val($(obj).val().replace(/[^0-9]/g,"") );
	    });
	}
	
</script>

</head>
<body>

	<form action="" name="allowanceDataFrm" id="allowanceDataFrm" method="post">
		<div id="oneDiv" class=""oneDiv"">
			<div id="topDiv">top</div>
			<div id="top2Div">
				<div id="leftDiv">
					<ul>
						<li>직원정보</li>
						<li>수당정보</li>
						<li>급여대장</li>
						<li>개인별 급여내역</li>
						<li>급여집계표</li>
						<li>명세서</li>
						<li>퇴직금계산</li>
					</ul>
				</div>
				<div id="rightDiv">
					<table>
						<tr>
							<td>
								야근 시간당수당
							</td>
							<td>
								<input type="text" name="scomNhCst" id="scomNhCst" value='${ empty list ? "0": list.get(0).scomNhCst }' onkeydown="onlyNumber(this)" >
							</td>
							<td>
								차량 유지비
							</td>
							<td>
								<input type="text" name="sempCmc" id="sempCmc" value='${ empty list ? "0": list.get(0).sempCmc }' onkeydown="onlyNumber(this)" >
							</td>
						</tr>
						<tr>
							<td>
								주간 시간당수당
							</td>
							<td>
								<input type="text" name="scomHhCst" id="scomHhCst" value='${ empty list ? "0": list.get(0).scomHhCst }' onkeydown="onlyNumber(this)" >
							</td>
							<td>
								식대
							</td>
							<td>
								<input type="text" name="scomElhCst" id="scomElhCst" value='${ empty list ? "0": list.get(0).scomElhCst }' onkeydown="onlyNumber(this)" >
							</td>
						</tr>
						<tr>
							<td>
								지각
							</td>
							<td>
								<input type="text" name="scomLhCst" id="scomLhCst" value='${ empty list ? "0": list.get(0).scomLhCst }' onkeydown="onlyNumber(this)" >
							</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td>
								<input type="button" value="저장" onclick="AllowanceSaveAjax()">
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>
	
</body>
</html>