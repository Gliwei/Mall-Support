<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

    <div class="page-ctrl">
    	<span class="pageinfo">
        	<i class="icon-caret-right"></i>
        	共<span class="num">${pageable.count}</span>条记录 , 
            每页<input class="page-size" name="pageSize" value="${pageable.rows}" title="改变每页显示的条数,回车跳转" />条 , 
            共<span class="num">${pageable.pages}</span>页
        </span>
        <script type="text/javascript">
       	var url = "${param.url}";
        $(function(){
        	var $pageCtrl = $(".page-ctrl");
        	var page = ${pageable.page}; // 当前页
        	var pages = ${pageable.pages}; // 总页数
        	console.info(url);
        	console.info(page);
        	console.info(pages);
        	
        	// 首页按钮
        	// <span class="page"><i class="icon-fast-backward"></i></span>
        	
        	if(page>1){
        		$pageCtrl.append('<span class="prev" onclick="gopage('+ (page-1) +')"><i class="icon-backward"></i> 上一页</span>');
        	}
        	
        	// <span class="page">4</span>
        	$pageCtrl.append('<span class="pageon">'+ page +'</span>');
        	
        	if(page<pages){
        		$pageCtrl.append('<span class="next" onclick="gopage('+ (page+1) +')">下一页 <i class="icon-forward"></i></span>');
        	}
        	
        	// 尾页按钮
        	// <span class="page"><i class="icon-fast-forward"></i></span>
        });
        var selectModal = "${param.modal}";
        function gopage(page){
        	var param = $("#search-form").serialize();
        	var href = url + page + "?" + param;
        	if(selectModal.length>0){
        		$("#select-box-modal .cnt").load(href);
        	} else {
        		location.replace(href);
        	}
        }
        </script>
    </div>