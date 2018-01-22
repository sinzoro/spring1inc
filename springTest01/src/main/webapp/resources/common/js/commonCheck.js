function test() {
	alert("test");
}


function onKeyNumberCheck(obj) {
	$(obj).keyup(function(){
    	$(this).val($(this).val().replace(/[^0-9]/g,""));
	});
}


