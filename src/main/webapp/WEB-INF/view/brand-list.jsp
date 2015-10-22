<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" scope="session" value="/mall-support/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>表格</title>
<script src="${root}js/jquery-2.1.4.js"></script>
<link href="${root}css/common-ui.css" rel="stylesheet" type="text/css" />
<link href="${root}css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<script>
	$(function(){

		//标题右侧按钮的动画效果
		/*$(".right-icon").hover(function(){
			/* 含羞草
			$(this).css({"position":"relative","overflow":"hidden"})
				.find("i").css({"position":"relative","top":0})
					.animate({"top":20},100,function(){
						$(this).animate({"top":0},300);	
					});
			*/
			/* 滚动 */
			/*$(this).css({"position":"relative","overflow":"hidden"})
				.find("i").css({"position":"relative","top":0})
				.animate({"top":-30},150,function(){
					$(this).css({"top":30}).animate({"top":0},200);	
				});
		},function(){});*/
		
		//表格最后一列《管理按钮栏》的展开和折叠功能
		var ltd = $("table.simple-table tr td").filter(":last-child");
		ltd.children().hide();
		var mopen = false;
		$("#mth").width(25).click(function(e) {
			if(mopen){
				//折叠
				ltd.children().hide();
				$(this).find("#text").html("");
				$(this).find("i").attr("class","icon-angle-left");
				$(this).animate({width:25},200,function(){
					mopen = false;
				});
			}else{
				//打开
				$(this).animate({width:100},200,function(){
					$(this).find("i").attr("class","icon-angle-right");
					ltd.children().show();
					mopen = true;
					$(this).find("#text").html("管理");
				});
			}
        });
		
		//全选
		$("#checkAll").click(function(e) {
            $("table.simple-table tbody tr td:first-child :checkbox").attr("checked",this.checked);
        });
		
		//鼠标经过标题高亮显示列
		$("table.simple-table th").hover(function(){
			var idx = $(this).index();
			$(this).parent().parent().parent()//table
				.find("td,th").filter(":nth-child(" + (idx+1) + ")")
				.addClass("th-hover");
		},function(){
			var idx = $(this).index();
			$(this).parent().parent().parent()//table
				.find("td,th").filter(":nth-child(" + (idx+1) + ")")
				.removeClass("th-hover");
		});
		
		//表格数据检索（过滤，高亮显示）
		var allRows = $("table.simple-table tbody td");
		$("#finp").on("keydown keyup",function() {
			var fval = $(this).val().replace("\s","");
			allRows.removeClass("highlight");
			if(fval!=null && fval.length>0){
				$("table.simple-table tbody td:contains('" + fval + "')").addClass("highlight");
			}
		}).focusout(function(e) {
            var ths = $(this).parent();
			ths.hide(200);
        });
		
		//点击展开过滤框
		$("#fbtn").click(function(e) {
            var ths = $(this);
			ths.siblings(".filter-box").show(200).find("input").focus();
        });
		
		//选中行添加样式
		$("table.simple-table tbody input[type=checkbox]").click(function(e) {
            if(this.checked==true){
				$(this).parent().parent().addClass("checked");
			} else {
				$(this).parent().parent().removeClass("checked");
			}
        });
		
		$(".search-box input[type=text]").focus(function(e) {
            $(this).animate({"width":130},300);
        }).focusout(function(e) {
            if($(this).val()==""){
				$(this).animate({"width":70},300);
			}
        });
	});
</script>
</head>

<body>

    <div class="c-tit">
        <span class="text">
        	<i class="icon-bookmark"></i>
            <span>列表编辑</span>
        </span>
        <span class="search-box">
            编号: <input type="text" />
            名称: <input type="text" />
            <span class="sbtn"><i class="icon-search"></i> 搜索</span>
            <span class="cbtn" title="清除搜索条件">&nbsp;<i class="icon-eraser"></i>&nbsp;</span>
        </span>
        <span class="right-icon refresh" title="刷新">
            <i class="icon-refresh"></i>
        </span>
        <a href="${root}brand/addpage">
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
                <th>Logo</th>
                <th>ID</th>
                <th>Name</th>
                <th>EnName</th>
                <th>description</th>
                <th id="mth"><span id="text"></span><i class="icon-angle-left"></i></th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${pageable.list}" var="brand">
            <tr>
                <td><input type="checkbox" /></td>
                <td class="uname"><img src="${brand.logoBigUrl}" class="img-rounded" width="25px"></td>
                <td>${brand.id}</td>
                <td>${brand.name}</td>
                <td>${brand.enName}</td>
                <td>${brand.description}</td>
                <td>
                	<i class="icon-edit" onclick="loadPage('${root}brand/addpage?id=${brand.id}')"></i>
                	<i class="icon-remove"></i>
               	</td>
            </tr>
            </c:forEach>         
        </tbody>
    </table>
    <div class="page-ctrl">
    	<span class="pageinfo">
        	<i class="icon-caret-right"></i>
        	共<span class="num">203</span>条记录 , 
            每页<input class="page-size" name="pageSize" value="20" title="改变每页显示的条数,回车跳转" />条 , 
            共<span class="num">20</span>页
        </span>
        <span class="page"><i class="icon-fast-backward"></i></span>
        <span class="prev"><i class="icon-backward"></i> 上一页</span>
        <span class="page">1</span>
        <span class="page">2</span>
        <span class="page">3</span>
        <span class="page">4</span>
        <span class="pageon">5</span>
        <span class="page">6</span>
        <span class="page">7</span>
        <span class="page">8</span>
        <span class="page">9</span>
        <span class="page">10</span>
        <span class="next">下一页 <i class="icon-forward"></i></span>
        <span class="page"><i class="icon-fast-forward"></i></span>
    </div>
</body>
</html>