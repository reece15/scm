(function(jQuery){
	/**
	 * 删除插件
	 */
	$.deleteObj = function(config){
		/**
		 * config.id代表删除按钮的id的值
		 */
		$("#"+config.id).unbind("click");
		$("#"+config.id).bind("click", function(){
			//表格中没有被选中的
			if($("input[name='"+config.checkboxname+"']:checked").length == 0){
				alert("请选中一个再删除!");
			}else{
				if(window.confirm("您确认要删除吗？")){
					var checkedNodes = $("input[name='"+config.checkboxname+"']:checked");
					var checkedStr = "";
					
					for(var i = 0; i < checkedNodes.length; i++){
						if(i == checkedNodes.length - 1){
							checkedStr = checkedStr + $(checkedNodes[i]).attr("value");
						}else{
							checkedStr =  checkedStr + $(checkedNodes[i]).attr("value") + ",";
						}
					}
					
					window.location.href = config.url + "?checkedStr=" + checkedStr;
					return true;
				}else{
					return false;
				}
			}
			
			
		});
		
		/**
		 * 单独删除
		 */
		$("input[name='"+config.delName+"']").unbind("click");
		$("input[name='"+config.delName+"']").bind("click", function(){
			var id = $(this).parent().siblings("td:first").children("input").attr("value");
			window.location.href = config.url + "?checkedStr=" + id;
		});
		/**
		 * 全选checkbox的处理
		 */
		$("#"+config.controlCheckBox).unbind("click");
		$("#"+config.controlCheckBox).bind("click", function(){
			if($(this).attr("checked")){
				$("input[name='"+config.checkboxname+"']").attr("checked",true);
			}else{
				$("input[name='"+config.checkboxname+"']").attr("checked",false);
			}
		});
		
		/**
		 * 表格中的checkbox的处理
		 */
		$("input[name='"+config.checkboxname+"']").unbind("click");
		$("input[name='"+config.checkboxname+"']").bind("click", function(){
			//checkbox被全部选中
			if($("input[name='"+config.checkboxname+"']:not(:checked)").length == 0){
				$("#"+config.controlCheckBox).attr("checked",true);
			}else{
				$("#"+config.controlCheckBox).attr("checked",false);
			}
		});
	}
})(jQuery);