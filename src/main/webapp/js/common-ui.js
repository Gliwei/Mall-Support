// JavaScript Document
$(function(){
	/** 页头右侧按钮点击事件监听 */
	$(".c-tit .refresh").click(function(){
		alert(location.href);
		location.replace(location.href);
	});
	
	$(".c-tit .bak").click(function(){
		history.back();
	});
	
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
				$(this).find("#text").html("收起");
			});
		}
    });
	
	//全选
	$("#checkAll").click(function(e) {
        $("table.simple-table tbody tr td:first-child :checkbox").attr("checked",this.checked);
    });
	
	//鼠标经过标题高亮显示列
	/* $("table.simple-table th").hover(function(){
		var idx = $(this).index();
		$(this).parent().parent().parent()//table
			.find("td,th").filter(":nth-child(" + (idx+1) + ")")
			.addClass("th-hover");
	},function(){
		var idx = $(this).index();
		$(this).parent().parent().parent()//table
			.find("td,th").filter(":nth-child(" + (idx+1) + ")")
			.removeClass("th-hover");
	}); */
	
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
	
	var kw = $("input[name=kw]").val();
	if(kw!=null && kw.length>0){
		$("table.simple-table tbody td:contains('" + kw + "')").addClass("highlight");
	}
	
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
	
	/*$(".search-box input[type=text]").focus(function(e) {
        $(this).animate({"width":200},300);
    }).focusout(function(e) {
        if($(this).val()==""){
			$(this).animate({"width":100},300);
		}
    });*/
	
	$("button[data-select=true]").click(function(e) {
		var url = $(this).attr("data-remote");
		var selectModal = $("#select-box-modal");
		selectModal.find(".cnt").html("").load(url, function(){
			selectModal.fadeIn(200);
		});
    });
});