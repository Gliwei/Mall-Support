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
            <span>Commodity List</span>
        </span>
        <form action="commodity/search" method="get" id="search-form">
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
        <a href="commodity/editpage">
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
                <th>mainPicture</th>
                <th>product</th>
                <th>SKU</th>
                <th>Title</th>
				<th>SalePrice</th>
				<th>CostPrice</th>
                <th id="mth"><span id="text"></span><i class="icon-angle-left"></i></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${pageable.list}" var="entity">
            <tr>
                <td><input type="checkbox" /></td>
                <td>${entity.id}</td>
                <td><img src="${entity.mainPicture}"></td>
                <td>${entity.product.title}</td>
                <td>${entity.sku}</td>
                <td>${entity.title}</td>
                <td>${entity.salePrice}</td>
                <td>${entity.costPrice}</td>
                <td>
                	<a href="commodity/editpage?id=${entity.id}"><i class="icon-edit"></i></a>
                	<i class="icon-remove"></i>
               	</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:import url="../common/page.jsp">
    	<c:param name="url" value="commodity/list/" />
    </c:import>
</body>
</html> 