<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	//PDF출력
	function fnPrintPDF() {
		alert("pdf");
		
		var frm = document.frm;
		var width  = 800;
		var height = 600;
		var px     = (screen.availWidth - width) / 2;
		var py     = (screen.availHeight - height) / 2;
		var pos    = "top=" + py + ",left=" + px;
		
		var features = pos + ", width=" + width + ", height=" + height;
		window.open("", "PRINT_IREPORT", features);
		frm.target = "PRINT_IREPORT";
		
		frm.action = "/report/iReportPrint.do";
		frm.method = "post";
		frm.submit();
	}


</script>

</head>
<body>

<form name="frm">
	<input type="button" value="pdf" onclick="fnPrintPDF()" >
</form>


</body>
</html>