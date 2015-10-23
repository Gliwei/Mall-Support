<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" scope="session" value="/mall-support/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>品牌</title>
<link href="${root}bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${root}css/common-ui.css" rel="stylesheet" type="text/css" />
<link href="${root}css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<script src="${root}js/jquery-2.1.4.js"></script>
<script src="${root}bootstrap/js/bootstrap.min.js"></script>
<%-- <script src="${root}jquery-validation/jquery.validate.js"></script> --%>
<script type="text/javascript">
	//$("#brandForm").validate();
</script>
</head>
<body>
	<div class="container-fluid">
		<c:if test="${!empty msg}">
			<div class="container" style="margin-top: 40px;">
				<div class="jumbotron">
					<h1>${msg}</h1>
					<p>Successful operation, next step</p>
					<p>
						<a class="btn btn-primary btn-lg" role="button"
							href="${root}brand/list"> view list </a>
					</p>
				</div>
			</div>
		</c:if>
		<c:if test="${empty msg}">
			<div class="c-tit" style="margin-bottom: 50px;">
		        <span class="text">
		        	<i class="icon-bookmark"></i>
		            <span>品牌编辑</span>
		        </span>
		        <span class="right-icon refresh" title="刷新">
		            <i class="icon-refresh"></i>
		        </span>
		        <span class="right-icon filter" title="过滤当前页数据">
		            <i class="icon-filter" id="fbtn"></i>
		            <span class="filter-box" style="display:none">
		            	<input type="text" id="finp" placeholder="请输入" />
		        	</span>
		        </span>
		    </div>
		    
			<form class="form-horizontal" role="form" action="${root}brand/save"
				method="post" id="brandForm">
				<input type="hidden" name="id" value="${brand.id}">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">品牌名</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="name" name="name"
							value="${brand.name}" required>
					</div>
				</div>
				<div class="form-group">
					<label for="enName" class="col-sm-2 control-label">英文名</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="enName" name="enName"
							value="${brand.enName}">
					</div>
				</div>
				<div class="form-group">
					<label for="description" class="col-sm-2 control-label">description</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="description"
							name="description" value="${brand.description}">
					</div>
				</div>
				<div class="form-group">
					<label for="logoBigUrl" class="col-sm-2 control-label">logoBigUrl</label>
					<div class="col-sm-6">
						<input type="url" class="form-control" id="logoBigUrl"
							name="logoBigUrl" value="${brand.logoBigUrl}" required>
					</div>
				</div>
				<div class="form-group">
					<label for="logoSamllUrl" class="col-sm-2 control-label">logoSamllUrl</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="logoSamllUrl"
							name="logoSamllUrl" value="${brand.logoSamllUrl}">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-6">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>
		</c:if>
	</div>
</body>
</html>