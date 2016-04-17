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
<!-- 多选框插件 -->
<link href="${rootPath}assets/plugins/jquery-multi-select/css/multi-select.css" rel="stylesheet"/>
<script src="${rootPath}assets/plugins/jquery-multi-select/js/jquery.multi-select.js"></script>
<%-- <script src="${root}jquery-validation/jquery.validate.js"></script> --%>
<script type="text/javascript">
$(function() {
	var cid = ${entity.id};
	$('#optgroup').multiSelect({
		selectableOptgroup: true,
		selectableHeader: "<div class='custom-header'>未选择</div>",
		selectionHeader: "<div class='custom-header'>已选择</div>",
		afterSelect: function(val){
			// 选择
			$.post("${rootPath}commodity/saveC2P","id="+cid+"&itemIds="+val,function(result){
				// alert(result);
			});
		},
		afterDeselect: function(val){
			// 取消选择
			$.post("${rootPath}commodity/delC2P","id="+cid+"&itemIds="+val,function(result){
				// alert(result);
			});
		}
		});
})
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
							href="${rootPath}commodity/list"> view list </a>
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
			<form class="form-horizontal form-bordered form-small" role="form" id="entityForm" ><!-- form-bordered -->
				<div class="form-body">
					<input type="hidden" name="id" value="${entity.id}">
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">SKU</label>
								<div class="controls">
									<input type="text" class="form-control" value="${entity.sku}" disabled>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Product</label>
								<div class="input-group">
									<input type="text" class="form-control" 
										value="${entity.product.spu} \ ${entity.product.title}" readonly>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Main Picture</label>
								<div class="controls">
									<input type="text" class="form-control" value="${entity.mainPicture}" readonly>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Title</label>
								<div class="controls">
									<input type="text" class="form-control" value="${entity.title}" readonly>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Sub Title</label>
								<div class="controls">
									<input type="text" class="form-control" value="${entity.subtitle}" readonly>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Sale Price</label>
								<div class="controls">
									<input type="text" class="form-control" value="${entity.salePrice}" readonly>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Cost Price</label>
								<div class="controls">
									<input type="text" class="form-control" value="${entity.costPrice}" readonly>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-12">
							<div class="form-group itemlist">
								<label class="control-label">Property</label>
								<div class="controls">
									<select id='optgroup' multiple='multiple'>
									  <c:forEach items="${propertyList}" var="property" >
									  <optgroup label='${property.name}'>
									    <c:forEach items="${property.propertyitems}" var="item" >
									    <option value='${item.id}' 
									    <c:forEach items="${entity.commodity2propertyitems}" var="c2p" >
									     	<c:if test="${c2p.propertyitem.id == item.id}"> selected </c:if>
									    </c:forEach>
									    >${item.itemName}</option>
									    </c:forEach>
									  </optgroup>
									  </c:forEach>
									</select>
							    </div>
							</div>
						</div>
					</div>
					
				</div>
				<div class="form-actions fluid">
				</div>
			</form>
			</div>
		</c:if>
	</div>
</body>
</html>