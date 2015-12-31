<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="/mall-support/">
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
          Select
       </h4>
    </div>
    <div class="modal-body">

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
        	<c:forEach items="${pageable.list}" var="brand">
            <tr>
                <td><input type="radio" name="selectRadio" value="${brand.id}" data-info="${brand.id} | ${brand.name}"/></td>
                <td>${brand.id}</td>
                <td>${brand.name}</td>
                <td>${brand.category.name}</td>
                <td>${brand.description}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:import url="../common/page.jsp">
    	<c:param name="url" value="category/select/" />
    </c:import>
    </div>
       <div class="modal-footer">
          <button type="button" class="btn btn-default" 
             data-dismiss="modal">关闭
          </button>
          <button type="button" class="btn btn-primary" onclick="selectCallbak();" data-dismiss="modal">
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
	}
</script>
</html>