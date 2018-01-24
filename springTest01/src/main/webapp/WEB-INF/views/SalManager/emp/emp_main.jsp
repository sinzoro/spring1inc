<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script src="resources/common/js/jquery-3.2.1.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="resources/common/js/paging.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>

var new_checklength = ${countnew};
var exi_checklength = ${countexi};
var checkcount = 0;
$(document).ready(function(){
    //최상단 체크박스 클릭
    $("#checkalln").click(function(){
        //클릭되었으면
        if($("#checkalln").prop("checked")){
            //input태그의 name이 chkn으로 시작인 태그들을 찾아서 checked옵션을 true로 정의
            $("input[name^=chkn]").prop("checked",true);
            //클릭이 안되있으면
        }else{
            //input태그의 name이 chkn으로 시작인 태그들을 찾아서 checked옵션을 false로 정의
            $("input[name^=chkn]").prop("checked",false);
        }
    });
    
    $("#checkalle").click(function(){
        //클릭되었으면
        if($("#checkalle").prop("checked")){
            //input태그의 name이 chke으로 시작인 태그들을 찾아서 checked옵션을 true로 정의
            $("input[name^=chke]").prop("checked",true);
            //클릭이 안되있으면
        }else{
            //input태그의 name이 chke으로 시작인 태그들을 찾아서 checked옵션을 false로 정의
            $("input[name^=chke]").prop("checked",false);
        }
    });
}) ;

	function new_emp_code(){		//신규계산 체크폼
		
		var frm = document.f1;
		
		for(var i=0; i<new_checklength; i++) {
			
			if($("input[name=chkn"+i+"]").prop("checked") == false){
				checkcount++;
			}
		}
	
		if(checkcount !=new_checklength) {
			frm.action = "/spring/new_empcode.do";
			frm.submit();
		}
		else{
			alert("아무것도 체크하지 않았습니다.!");
		}
		checkcount = 0;
   }
	
   function exi_emp_code(){		//기존계산 체크폼
		
		var frm = document.f2;
		
		for(var i=0; i<exi_checklength; i++) {
			
			if($("input[name=chke"+i+"]").prop("checked") == false){
				checkcount++;
			}
		}
	
		if(checkcount !=exi_checklength) {
			frm.action = "/spring/exi_empcode.do";
			frm.submit();
		}
		else{
			alert("아무것도 체크하지 않았습니다.!");
		}
   }  
</script>
</head>
<body>
	<div class="main-content">

		<div class="container-fluid">
			<h3 class="page-title">직원급여정보</h3>

			<div class="col-sm-4">
				
				<div class="panel">
					<div class="panel-heading">

					   <form name="f1">
						<div class="panel-body">
							<h4>신규계산</h4>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th><input type="checkbox" id="checkalln" /></th>
										<th>코드&nbsp;&nbsp;</th> 
										<th>이름</th>
										<th>부서</th>
										<th>입사일자</th>
									</tr>
								</thead>
								<c:forEach var="tb" items="${listNew}" varStatus="status">
								<tr>
									<td>
										<input type="checkbox" name="chkn${status.index}" value="${tb.EMP_EMNO}" /> 
									</td>
									<td>
										${tb.EMP_EMNO}
										
									</td>
									
									<td>
										${tb.EMP_NAME}
									</td>
									<td></td>
									<td></td>
								</tr>
								</c:forEach>
							
							</table>
							<input type="submit" value="신규계산" onclick="new_emp_code();" class="btn btn-success">
						</div>
					   </form>
						
					</div>
				</div>
			</div>
			
			<div class="col-sm-4">
			   
				<div class="panel">
					<div class="panel-heading">

					   <form name="f2">
						<div class="panel-body">
						    <h4>기존계산</h4>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th><input type="checkbox" id="checkalle" /></th>
										<th>코드&nbsp;&nbsp;</th> 
										<th>이름</th>
										<th>부서</th>
										<th>입사일자</th>
									</tr>
								</thead>
								<c:forEach var="tb" items="${listExi}" varStatus="status">
								<tr>
									<td>
										<input type="checkbox" name="chke${status.index}" value="${tb.EMP_EMNO}" /> 
									</td>
									<td>
										${tb.EMP_EMNO}
										
									</td>
									
									<td>
										${tb.EMP_NAME}
									</td>
									<td></td>
									<td></td>
								</tr>
								</c:forEach>
							
							</table>
							<input type="submit" value="기존계산" class="btn btn-danger" onclick="exi_emp_code();">
						</div>
					   </form>
						
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>