<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" scope="session" value="/mall-support/" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${root}css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${root}css/index.css" />
<script type="text/javascript" src="${root}js/jquery-1.7.1.js"></script>
<script type="text/javascript">
	// JavaScript Document
	$(function() {
		// loadPage("table.html");
		$("body").hide(0).fadeIn(500);

		$(".item-title").click(function(e) {
			$(this).siblings("ul").slideToggle(300);
		});

		$(".nav li").click(function(e) {
			var url = $(this).attr("url");
			loadPage(url, this);
		});

		var leftW = 220;
		var content = $(".g-container .content");
		$("#hide-left").click(function() {
			var ths = $(this);

			$("div.nav").slideToggle(0, function() {
				content.toggleClass("ml");
			});
			ths.find("i").toggleClass("icon-chevron-sign-right");
		});
	});

	function loadPage(url, node) {
		var main = $(".content .inner iframe");
		main.attr("src", url);
		/* $.post(url, function(result) {
			var main = $(".content .inner");
			main.html(result);
			main.hide(0).fadeIn(300);
			console.info(main);
			$(".nav li").css("background-color", "inherit");
			$(node).css("background-color", "#FFF");
		}, "html"); */
	}
	function iFrameHeight() {
        var ifm= document.getElementById("iframepage");
        var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;
        if(ifm != null && subWeb != null) {
        	ifm.height = subWeb.body.scrollHeight;
        }
    }
</script>
</head>

<body>
	<div class="header">
		<div class="base">
			<div class="logo-box">管理平台</div>
			<div class="menu-box">
				<ul class="left-menu">
					<li id="hide-left"><i class="icon-chevron-sign-left"></i>隐藏</li>
					<li>登陆页</li>
				</ul>
				<ul class="right-menu">
					<li>Conan</li>
					<li>Exit</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="g-container">
		<div class="base">
			<div class="nav">
				<div class="left-nav">
					<div class="nav-search">
						<input placeholder="菜单搜索" />
					</div>
					<div class="tool-bar">
						<span><i class="icon-screenshot"></i></span> <span><i
							class="icon-minus-sign-alt"></i></span>
					</div>
					<div class="item">
						<div class="item-title" current="true">
							<a href="#">货品与分类</a>
						</div>
						<ul>
							<li url="${root}brand/list/1"><a href="#">品牌管理</a></li>
							<li url="table-2.html"><a href="#">商品管理</a></li>
							<li><a href="#">分类管理</a></li>
						</ul>
					</div>
					<div class="item">
						<div class="item-title">
							<a href="#">订单与物流</a>
						</div>
						<ul>
							<li><a href="#">订单管理</a></li>
							<li><a href="#">待添加</a></li>
							
						</ul>
					</div>
				</div>
			</div>
			<div class="content ml">
				<div class="inner">
					<iframe src="${root}brand/addpage" id="iframepage" onLoad="iFrameHeight()"></iframe>
				</div>
			</div>
		</div>
	</div>
	<!-- <div class="footer">
    	<div class="base">
        	<div class="inner">
    			&nbsp;
            </div>
        </div>
    </div> -->
</body>
</html>