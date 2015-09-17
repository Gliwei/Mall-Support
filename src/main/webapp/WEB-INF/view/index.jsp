<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/mall-support/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
$(function(){
	var searchField = $("form#search input");
	var qclist = new Array();
	$.each(function(){
		qclist.push({propertyName: "title", operator: "LIKE", propertyValue: "iPhone"});
	});
	$.post("", JSON.stringify(qclist), function(data){
		$("#data").html(data);
	});	
});
</script>
</head>
<body>
	<h1>Local</h1>
	<form id="search">
		<input name="title" data-op="LIKE"/>
		<input name="price" data-op="EQ"/>
	</form>
	<div id="data">
	</div>
</body>
</html>
