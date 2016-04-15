<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mall Support System (H)</title>
<!-- 字体图标 -->
<link href="${rootPath}css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${rootPath}css/index.css" />
<script src="${rootPath}js/jquery-2.1.4.js"></script>
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
			ths.find("i").toggleClass("icon-circle-arrow-right");
		});
	});

	function loadPage(url, node) {
		var main = $(".content .inner iframe");
		main.attr("src", url);
		$(".nav li").css("background-color", "inherit");
		$(node).css("background-color", "#FFF");
	}
	
	function resizeIframe(obj) {
		obj.style.height = 0;

		var innerH = $(window).height() - 60;//60 为 header高度40 + inner padding 20;
		var height = obj.contentWindow.document.body.scrollHeight;
		if(height<innerH)height=innerH;
		
		obj.style.height = height + 'px';
	}
</script>
</head>

<body>
	<div class="header">
		<div class="base">
			<div class="logo-box">Platform</div>
			<div class="menu-box">
				<ul class="left-menu">
					<li id="hide-left"><i class="icon-circle-arrow-left"></i></li>
					<li>Login</li>
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
						<input placeholder="Menu search" />
					</div>
					<div class="tool-bar">
						<span><i class="icon-screenshot"></i></span> <span><i
							class="icon-minus-sign-alt"></i></span>
					</div>
					<div class="item">
						<div class="item-title" current="true">
							<a href="#">Product Unit</a>
						</div>
						<ul>
							<li url="brand/list">Brand</li>
							<li url="category/list">Category</li>
							<li url="product/list"><a href="#">Product</a></li>
							<li url="commodity/list"><a href="#">Commodity</a></li>
						</ul>
					</div>
					<div class="item">
						<div class="item-title">
							<a href="#">Order Unit</a>
						</div>
						<ul>
							<li><a href="#">Order</a></li>
							<li><a href="#">adding..</a></li>
							<li><a href="#">adding..</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="content ml">
				<div class="inner">
					<iframe src="welcome" id="iframepage" frameborder="0" scrolling="no" 
						onLoad="resizeIframe(this)"></iframe>
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