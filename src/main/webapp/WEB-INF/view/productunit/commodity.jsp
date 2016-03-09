<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="/mall-support/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>edit page</title>
<!-- bootstrap -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- assets 扁平化UI -->
<link href="assets/css/style-metronic.css" rel="stylesheet"/>
<link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
<!-- 字体图标 -->
<link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<!-- 自定义组件/样式 -->
<link href="css/common-ui.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-2.1.4.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/common-ui.js"></script>
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
							href="${root}commodity/list"> view list </a>
					</p>
				</div>
			</div>
		</c:if>
		<c:if test="${empty msg}">
			<div class="c-tit" style="margin-bottom: 10px;">
		        <span class="text">
		        	<i class="icon-bookmark"></i>
		            <span>Commodity Edit</span>
		        </span>
		        <span class="right-icon refresh" title="刷新">
		            <i class="fa fa-refresh"></i>
		        </span>
		        <span class="right-icon bak" title="返回">
		            <i class="fa fa-chevron-left"></i>
		        </span>
		    </div>
		    
			<div class="portlet-body form">
			<form class="form-horizontal form-bordered form-small" role="form" action="commodity/save"
				method="post" id="entityForm"><!-- form-bordered -->
				<div class="form-body">
					<input type="hidden" name="id" value="${entity.id}">
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Product</label>
								<div class="input-group">
									<input type="hidden" name="product.id">
									<input type="text" class="form-control" id="productInfo"
										value="${entity.product.id}" readonly>
									<span class="input-group-btn">
										<button class="btn default" type="button" data-select="true" 
											data-remote="product/select/1?f=productInfo">
											<i class="fa fa-search"></i>
										</button>
									</span>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Main Picture</label>
								<div class="controls">
									<input type="text" class="form-control" id="mainPicture" name="mainPicture"
										value="${entity.mainPicture}">
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Title</label>
								<div class="controls">
									<input type="text" class="form-control" id="title" name="title"
										value="${entity.title}">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Sub Title</label>
								<div class="controls">
									<input type="text" class="form-control" id="subtitle" name="subtitle"
										value="${entity.subtitle}" required>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Sale Price</label>
								<div class="controls">
									<input type="text" class="form-control" id="title" name="salePrice"
										value="${entity.salePrice}">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Cost Price</label>
								<div class="controls">
									<input type="text" class="form-control" id="subtitle" name="costPrice"
										value="${entity.costPrice}" required>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="control-label">Html Description</label>
								<div class="controls">
									<textarea class="form-control" name="htmlDescription" >${entity.htmlDescription}</textarea>
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
<h1>TEST</h1>
		</c:if>
	</div>
</body>
</html>