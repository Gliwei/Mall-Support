<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>list page</title>
</head>

<body>

	<div class="modal-header">
       <h4 class="modal-title" id="myModalLabel">
          Select SPEC
       </h4>
    </div>
    
    <div>
     	<c:forEach items="${pageable.list}" var="entity">
     		<div class="flat-title">${entity.name}</div>
     		<ul class="flat">
     		<c:forEach items="${entity.specitems}" var="item">
	     		<li>
	     			<input type="checkbox">
					${item.itemName}
				</li>
			</c:forEach>
			</ul>
        </c:forEach>
	    <c:import url="../common/page.jsp">
	    	<c:param name="url" value="${rootPath}spec/select/" />
	    	<c:param name="modal" value="true" />
	    </c:import>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" 
           onclick="selectClose();">关闭
        </button>
        <button type="button" class="btn btn-primary" onclick="selectCallbak();" >
           提交更改
        </button>
    </div>
</body>
<script type="text/javascript">
	function selectCallbak(){
		var id = $("input[name='selectRadio']:checked").val();
		var info = $("input[name='selectRadio']:checked").attr("data-info");
		
		$("input[name='category.id']").val(id);
		$("#${f}").val(info);
		selectClose();
	}
	function selectClose(){
		var selectModal = $("#select-box-modal");
		selectModal.fadeOut(200);
	}
</script>
</html>