// JavaScript Document
function modifyWidth(){
	var w = $("#w").val();
	$("div.base").animate({"width":w},300);
}
$(function(){
	// Logo 变色
	setInterval(function(){
		var color = '#'+('00000'+(Math.random()*0x1000000<<0).toString(16)).slice(-6);
		$(".logo").animate({"color": color},3000);	
	}, 3000);
	
	/** 左侧分类导航栏fixed
	$(window).scroll(function(e) {
		var fixedNode = $(".nav .left-nav");//需要浮动的元素节点
		var scrollTop = $(window).scrollTop();
		var headerHight = $(".header").height();
		
		$("#test").html("scrollTop:"+scrollTop+" | headerHight"+headerHight);
		if(scrollTop>headerHight){
			fixedNode.css({"position":"fixed","top":"0","width":function(){
				return fixedNode.parent().width()-20;
			}});
		}else{
			fixedNode.css({"position":"static","width":"auto"});
		}
	});
	**/	
});