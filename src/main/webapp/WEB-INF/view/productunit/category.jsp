<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>edit page</title>
<!-- bootstrap -->
<link href="${rootPath}bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- assets 扁平化UI -->
<link href="${rootPath}assets/css/style-metronic.css" rel="stylesheet"/>
<link href="${rootPath}assets/css/style.css" rel="stylesheet" type="text/css"/>
<!-- 字体图标 -->
<link href="${rootPath}assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<!-- 自定义组件/样式 -->
<link href="${rootPath}css/common-ui.css" rel="stylesheet" type="text/css" />
<script src="${rootPath}js/jquery-2.1.4.js"></script>
<script src="${rootPath}bootstrap/js/bootstrap.min.js"></script>
<script src="${rootPath}js/common-ui.js"></script>
<%-- <script src="${root}jquery-validation/jquery.validate.js"></script> --%>
<script type="text/javascript">
	//$("#entityForm").validate();
</script>
</head>
<body>
	<div id="select-box-modal" class="select-box-modal"><div class="cnt"></div></div>
	<div class="container-fluid">
		<c:if test="${!empty msg}">
			<div class="container" style="margin-top: 40px;">
				<div class="jumbotron">
					<h1>${msg}</h1>
					<p>Successful operation, next step</p>
					<p>
						<a class="btn btn-primary btn-lg" role="button"
							href="${rootPath}category/list"> view list </a>
					</p>
				</div>
			</div>
		</c:if>
		<c:if test="${empty msg}">
			<div class="c-tit" style="margin-bottom: 10px;">
		        <span class="text">
		        	<i class="icon-bookmark"></i>
		            <span>Category Edit</span>
		        </span>
		        <span class="right-icon refresh" title="刷新">
		            <i class="fa fa-refresh"></i>
		        </span>
		        <span class="right-icon bak" title="返回">
		            <i class="fa fa-chevron-left"></i>
		        </span>
		    </div>
		    
			<div class="portlet-body form">
			<form class="form-horizontal form-bordered form-small" role="form" action="${rootPath}category/save"
				method="post" id="entityForm"><!-- form-bordered -->
				<div class="form-body">
					<input type="hidden" name="id" value="${entity.id}">
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Category Name</label>
								<div class="controls">
									<input type="text" class="form-control" id="name" name="name"
										value="${entity.name}" required>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Parent Category</label>
								<div class="input-group">
									<input type="hidden" name="category.id">
									<input type="text" class="form-control" id="categoryInfo"
										value="${entity.category.id}" readonly>
									<span class="input-group-btn">
										<button class="btn default" type="button" data-select="true"
											data-remote="${rootPath}category/select/1?f=categoryInfo">
											<i class="fa fa-search"></i>
										</button>
									</span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">Description</label>
								<div class="controls">
									<textarea class="form-control" name="description" >${entity.description}</textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="form-actions fluid">
					<div class="col-md-offset-2 col-md-10">
						<button type="submit" class="btn blue">Submit</button>
						<button type="button" class="btn default">Cancel</button> 
					</div>
				</div>
			</form>
			</div>

		</c:if>
	</div>
</body>
</html>