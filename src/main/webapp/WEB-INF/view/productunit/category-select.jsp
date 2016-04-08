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
       <button type="button" class="close" 
          data-dismiss="modal" aria-hidden="true">
             &times;
       </button>
       <h4 class="modal-title" id="myModalLabel">
          Select Category
       </h4>
    </div>
    <div>

    <table class="simple-table" id="selectTable">
        <thead>
            <tr>
                <th width="40px"></th>
                <th>ID</th>
                <th>Name</th>
                <th>Parent</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${pageable.list}" var="entity">
            <tr>
                <td><input type="radio" name="selectRadio" value="${entity.id}" data-info="${entity.id} | ${entity.name}"/></td>
                <td>${entity.id}</td>
                <td>${entity.name}</td>
                <td>${entity.category.name}</td>
                <td>${entity.description}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:import url="../common/page.jsp">
    	<c:param name="url" value="${rootPath}category/select/" />
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