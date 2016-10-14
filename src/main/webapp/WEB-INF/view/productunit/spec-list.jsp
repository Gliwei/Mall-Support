<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>list page</title>
<script src="${rootPath}js/jquery-2.1.4.js"></script>
<script src="${rootPath}js/common-ui.js"></script>
<link href="${rootPath}css/common-ui.css" rel="stylesheet" type="text/css" />
<link href="${rootPath}css/font-awesome.min.css" rel="stylesheet" type="text/css" />
</head>

<body>

    <div class="c-tit">
        <span class="text">
        	<i class="icon-bookmark"></i>
            <span>Product List</span>
        </span>
        <form action="${rootPath}spec/search" method="get" id="search-form">
        <span class="search-box">
        	<input type="hidden" name="fields" value="id/spu/brand.name" />
        	<input type="hidden" name="pageNo" value="1" placeholder="Enter keyword.."/>
            <input type="text" name="kw" value="${kw}"/>
            <button type="reset">&nbsp;<i class="icon-eraser"></i>&nbsp;</button>
            <button type="submit"><i class="icon-search"></i> search</button>
        </span>
        </form>
        <span class="right-icon refresh" title="刷新">
            <i class="icon-refresh"></i>
        </span>
        <a href="${rootPath}spec/editpage">
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
                <th>Category</th>
                <th>Item</th>
                <th id="mth"><span id="text"></span><i class="icon-angle-left"></i></th>
            </tr>
        </thead>
        <tbody>
        	<c:if test="${empty pageable.list}">
        		<td colspan="6">##  NONE  ##</td>
       		</c:if>
        	<c:forEach items="${pageable.list}" var="entity">
            <tr>
                <td><input type="checkbox" /></td>
                <td>${entity.id}</td>
                <td>${entity.name}</td>
                <td>${entity.category.name}</td>
                <td>
                	<a href="${rootPath}spec/editItemPage?id=${entity.id}">click edit item</a>
                </td>
                <td>
                	<a href="${rootPath}spec/editpage?id=${entity.id}"><i class="icon-edit"></i></a>
                	<i class="icon-remove"></i>
               	</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:import url="../common/page.jsp">
    	<c:param name="url" value="${rootPath}spec/list/" />
    </c:import>
</body>
</html> 