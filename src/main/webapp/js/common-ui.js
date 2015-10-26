// JavaScript Document
$(function(){
	/** 页头右侧按钮点击事件监听 */
	$(".c-tit .refresh").click(function(){
		location.replace(location.href);
	});
	
	$(".c-tit .bak").click(function(){
		history.back();
	});
});