<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="/mall-support/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>list page</title>
<script src="js/jquery-2.1.4.js"></script>
<script src="js/common-ui.js"></script>
<link href="css/common-ui.css" rel="stylesheet" type="text/css" />
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
</head>

<body>

    <div class="c-tit">
        <span class="text">
        	<i class="icon-bookmark"></i>
            <span>Category List</span>
        </span>
        <span class="search-box">
            id: <input type="text" />
            name: <input type="text" />
            <span class="sbtn"><i class="icon-search"></i> search</span>
            <span class="cbtn" title="清除搜索条件">&nbsp;<i class="icon-eraser"></i>&nbsp;</span>
        </span>
        <span class="right-icon refresh" title="刷新">
            <i class="icon-refresh"></i>
        </span>
        <a href="category/editpage">
        <span class="right-icon add" title="添加">
            <i class="icon-plus"></i>
        </span>
        </a>
        <span class="right-icon bath-del" title="删除选中项">
            <i class="icon-trash"></i>
        </span>
        <span class="right-icon filter" title="过滤当前页数据">
            <i class="icon-filter" id="fbtn"></i>
            <span class="filter-box" style="display:none">
            	<input type="text" id="finp" placeholder="请输入" />
        	</span>
        </span>
    </div>
    
    <table class="simple-table">
        <thead>
            <tr>
                <th width="40px"><input type="checkbox" id="checkAll"/></th>
                <th>ID</th>
                <th>Name</th>
                <th>Parent</th>
                <th>Description</th>
                <th id="mth"><span id="text"></span><i class="icon-angle-left"></i></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${pageable.list}" var="brand">
            <tr>
                <td><input type="checkbox" /></td>
                <td>${brand.id}</td>
                <td>${brand.name}</td>
                <td>${brand.category.name}</td>
                <td>${brand.description}</td>
                <td>
                	<a href="category/editpage?id=${brand.id}"><i class="icon-edit"></i></a>
                	<i class="icon-remove"></i>
               	</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:import url="../common/page.jsp">
    	<c:param name="url" value="category/list/" />
    </c:import>
</body>
</html> 