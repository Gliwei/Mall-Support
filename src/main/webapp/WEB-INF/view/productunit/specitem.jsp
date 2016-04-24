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
function add(tis) {
	$(tis).before('<li class="new"><input type="text" name="itemName"><i class="fa fa-save save" onClick="save(this)"></i><i class="fa fa-times" onClick="del(this)"></i></li>');
}
function del(tis){
	$(tis).parent().remove();
}
function save(tis, itemId) {
	var specId = "${entity.id}";
	var itemName = $(tis).siblings("input").val();
	$.post("${rootPath}spec/saveItem",{"id":itemId, "spec.id":specId, "itemName":itemName},function(result){
		if(result && result.state=="success"){
			$(tis).parent().css("background-color","#FFFFFF");
		}
	},"json");
}
</script>
</head>
<body>
	<div id="select-box-modal" class="select-box-modal"><div class="cnt"></div></div>
	<div class="container-fluid">
		<div class="c-tit" style="margin-bottom: 10px;">
	        <span class="text">
	        	<i class="icon-bookmark"></i>
	            <span>Spec Edit</span>
	        </span>
	        <span class="right-icon refresh" title="刷新">
	            <i class="fa fa-refresh"></i>
	        </span>
	        <span class="right-icon bak" title="返回">
	            <i class="fa fa-chevron-left"></i>
	        </span>
	    </div>
	    
		<div class="portlet-body form">
		<form class="form-horizontal form-bordered form-small" role="form" id="entityForm">
			<!-- form-bordered -->
			<div class="form-body">
				<input type="hidden" name="id" value="${entity.id}">
				
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">Category</label>
							<div class="input-group">
								<p class="form-control-static">${entity.category.id} | ${entity.category.name}</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">Name</label>
							<div class="controls">
								<p class="form-control-static">${entity.name}</p>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12">
						<div class="form-group itemlist">
							<label class="control-label">Items</label>
							<div class="controls">
								<ul class="flat">
									<c:forEach items="${entity.specitems}" var="specitem" varStatus="idx">
										<li>
											<input type="text" name="itemName" value="${specitem.itemName}"><i class="fa fa-save save" onClick="save(this,${specitem.id})"></i><i class="fa fa-times delete" title="删除" onClick="del(this)"></i>
										</li>
									</c:forEach>
									<li class="add" onclick="add(this);"><i class="fa fa-plus"></i></li>
							    </ul>
						    </div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-actions fluid">
				
			</div>
		</form>
		</div>
	</div>
</body>
</html>