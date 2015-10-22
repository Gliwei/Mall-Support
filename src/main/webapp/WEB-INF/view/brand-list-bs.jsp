<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" scope="session" value="/mall-support/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>品牌</title>
<link href="${root}bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="${root}js/jquery-2.1.4.js"></script>
<script src="${root}bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<table class="table table-striped table-hover">
		<caption>
			<a type="button" class="btn btn-primary btn-sm" href="${root}brand/addpage">add</a>
		</caption>
		<thead>
			<tr>
				<th>logo</th>
				<th>ID</th>
				<th>name</th>
				<th>enName</th>
				<th>###</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pageable.list}" var="brand">
			<tr>
				<td><img src="${brand.logoBigUrl}" class="img-rounded" width="25px"></td>
				<td>${brand.id}</td>
				<td>${brand.name}</td>
				<td>${brand.enName}</td>
				<td>
					<a type="button" class="btn btn-default btn-sm" href="${root}brand/addpage?id=${brand.id}">edit</a>
					<a type="button" class="btn btn-default btn-sm" href="${root}brand/del?id=${brand.id}">del</a>
					<a type="button" class="btn btn-default btn-sm" href="${root}brand/view?id=${brand.id}">view</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>