/**
 * 1.这么写是一个闭包
 * 	闭包:
 * 		1,实现函数及其变量的公有性和私有性
 * 		2.返回一个函数 而这个对象是任意组织的
 * 2.保证函数的安全性
 */
(function(jQuery){
	$.updateEvent=function(config){
		$("input[value='修改']").unbind("click");
		 $("input[value='修改']").bind("click", function(){
			 /**
			  * 1.获取id
			  */
			 var id = $(this).parent().siblings("td:first").children("input").attr("value");
			 //跳转
			 window.location.href = config.url + "?" + config.id + "=" + id;
		 });
	}
})(jQuery);