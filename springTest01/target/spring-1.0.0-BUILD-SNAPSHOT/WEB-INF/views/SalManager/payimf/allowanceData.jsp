<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" href="resources/common/css/allowance.css" type="text/css" />

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>

<script src="resources/common/js/commonCheck.js"></script>

<script>

	
	function AllowanceSaveAjax(){
		//alert("Allowance");
		//test();

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
								<input type="text" name="scomNhCst" id="scomNhCst" class="numberCheck" onkeydown="onKeyNumberCheck(this)" value='${ empty list ? "0": list.get(0).scomNhCst }' >
							</td>
							<td>
								차량 유지비
							</td>
							<td>
								<input type="text" name="sempCmc" id="sempCmc" class="numberCheck" onkeydown="onKeyNumberCheck(this)" value='${ empty list ? "0": list.get(0).sempCmc }'  >
							</td>
						</tr>
						<tr>
							<td>
								주간 시간당수당
							</td>
							<td>
								<input type="text" name="scomHhCst" id="scomHhCst" class="numberCheck" onkeydown="onKeyNumberCheck(this)" value='${ empty list ? "0": list.get(0).scomHhCst }' >
							</td>
							<td>
								식대
							</td>
							<td>
								<input type="text" name="scomElhCst" id="scomElhCst" class="numberCheck" onkeydown="onKeyNumberCheck(this)" value='${ empty list ? "0": list.get(0).scomElhCst }'  >
							</td>
						</tr>
						<tr>
							<td>
								지각
							</td>
							<td>
								<input type="text" name="scomLhCst" id="scomLhCst" class="numberCheck" onkeydown="onKeyNumberCheck(this)" value='${ empty list ? "0": list.get(0).scomLhCst }'>
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