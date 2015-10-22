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
		<c:if test="${!empty msg}">
			<div class="jumbotron">
				<h1>${msg}</h1>
				<p>Successful operation, next step</p>
				<p>
					<a class="btn btn-primary btn-lg" role="button"
						href="${root}brand/list/1.json"> view list </a>
				</p>
			</div>
		</c:if>
		<c:if test="${empty msg}">
			<form class="form-horizontal" role="form" action="${root}brand/add"
				method="post">
				<input type="hidden" name="id" value="${brand.id}">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">品牌名</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="name" name="name"
							value="${brand.name}">
					</div>
				</div>
				<div class="form-group">
					<label for="enName" class="col-sm-2 control-label">英文名</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="enName" name="enName"
							value="${brand.enName}">
					</div>
				</div>
				<div class="form-group">
					<label for="description" class="col-sm-2 control-label">description</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="description"
							name="description" value="${brand.description}">
					</div>
				</div>
				<div class="form-group">
					<label for="logoBigUrl" class="col-sm-2 control-label">logoBigUrl</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="logoBigUrl"
							name="logoBigUrl" value="${brand.logoBigUrl}">
					</div>
				</div>
				<div class="form-group">
					<label for="logoSamllUrl" class="col-sm-2 control-label">logoSamllUrl</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="logoSamllUrl"
							name="logoSamllUrl" value="${brand.logoSamllUrl}">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>
		</c:if>
	</div>
</body>
</html>