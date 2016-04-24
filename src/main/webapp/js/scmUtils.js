var scmUtils = {
	/**
	 * 基础数据模块
	 */
	basedata:{
		/**
		 * 基础数据模块的查询删除功能的js处理
		 */
		deleteObj:{
			/**
			 * 当页面上的复选框被选中时点击删除按钮要做的事情
			 */
			deleteObjFunction:function(config){
				$.deleteObj(config);
			}
		},
		/**
		 * 修改对象
		 */
		updateObj:{
			updateObjFunction:function(config){
				$.updateEvent(config);
			}
		},
		/**
		 * 分页的逻辑
		 */
		dispageP:{
			/**
			 * 当点击首页 上页 下页 尾页时 要跳转到action 
			 */
			linkNextPage:function(){
				//this为当前按钮
				var currentPage = $(this).attr("param");
				var url = $("body").data("url");
				window.location.href = url + "?currentPage=" + currentPage;
			}
		},
		/**
		 * 初始化事件
		 */
		initEvent:function(){
			
			//给首页绑定点击事件
			$("input[flag='firstPage']").unbind("click");
			$("input[flag='firstPage']").bind("click", function(){
				scmUtils.basedata.dispageP.linkNextPage.call(this);
			});
			//给尾页绑定点击事件
			$("input[flag='lastPage']").unbind("click");
			$("input[flag='lastPage']").bind("click", function(){
				scmUtils.basedata.dispageP.linkNextPage.call(this);
			});
			
			//给上一页绑定点击事件
			$("input[flag='prePage']").unbind("click");
			$("input[flag='prePage']").bind("click", function(){
				if($(this).attr("param") == "0"){
					alert("已经是首页了!");
				}
				else{
					scmUtils.basedata.dispageP.linkNextPage.call(this);
				}
			});
			//给下一页绑定点击事件
			$("input[flag='nextPage']").unbind("click");
			$("input[flag='nextPage']").bind("click", function(){
				if($(this).attr("param") > $(this).attr("last")){
					alert("已经最后一页了!");
				}
				else{
					scmUtils.basedata.dispageP.linkNextPage.call(this);
				}
			});
			
		}
	},
	/**
	 * 权限模块
	 */
	privilege:{
		
	},
	 /**
     * 业务模块
     */
    business: {
    	/**
		 * 所有的业务模块中的add操作
		 */
		add:{
			/**
			 * 给无税单价中的td下面的input添加blur事件
			 *   当该事件触发的时候，含税单价、含税金额、税额、折扣额自动计算
			 */
			wsdjBlurEvent:function(){
				$("td[item='wsdj']").delegate("input","blur",function(){
					scmUtils.business.add.accountMoney.call(this);
				})
			},
			/**
			 * 计算含税单价、含税金额等
			 */
			accountMoney:function(){
				//数量
				var sl = $(this).parent().siblings("td[item='sl']").children("input").attr("value");
				//税率
				var shulv = $(this).parent().siblings("td[item='shulv']").children("input").attr("value");
				//单品扣率
				var dpkl = $(this).parent().siblings("td[item='dpkl']").children("input").attr("value");
				//无税单价
				var wsdj = $(this).attr("value");
				//含税单价
				var hsdj = parseFloat(wsdj)*(1+parseFloat(shulv));
				$(this).parent().siblings("td[item='hsdj']").children("input").attr("value",hsdj);
				//无税金额
				var wsje = parseInt(sl)*parseFloat(wsdj);
				$(this).parent().siblings("td[item='wsje']").children("input").attr("value",wsje);
				//含税金额
				var hsje = parseFloat(hsdj)*parseInt(sl);
				$(this).parent().siblings("td[item='hsje']").children("input").attr("value",hsje);
				//税额
				var se = hsje-wsje;
				$(this).parent().siblings("td[item='se']").children("input").attr("value",se);
				//折扣额
				var zke = parseFloat(dpkl)*hsje;
				$(this).parent().siblings("td[item='zke']").children("input").attr("value",zke);
			},
			/**
			 *  点击增加，添加一行
			 */
			addRow:function(){
				/**
				 * 修改trClone中的td(行号的)的值加1
				 */
				var $trClone = scmUtils.business.add.divOpt.trClone;
				var $inputHH = $trClone.children("td[item='hh']").children("input");
				
				$inputHH.attr("value",parseInt($inputHH.attr("value"))+1);
				
				/**
				 * 修改tr下面的td的name:xsyddzhibs[0].spbm-->xsyddzhibs[1].spbm
				 */
				$trClone.children("td").each(function(){
					/**
					 * 商品名称的结构比较特殊
					 * 	td
					 *     div
					 *        input
					 */
					if($(this).attr("item")=="spmc"){
						/**
						 * xsyddzhibs[0].spbm
						 * xsyddzhibs[0].spbm-->xsyddzhibs,0].spbm,通过split[
						 * 0].spbm-->0,spbm,通过split]
						 */
						var $input = $(this).children("div").children("input");
						var oldNameValue = $input.attr("name");//原来的name属性的值
						var preNameValue = oldNameValue.split("[")[0]; //xsyddzhibs
						var middleNameValue = oldNameValue.split("[")[1].split("]")[0];
						var postNameValue = oldNameValue.split("[")[1].split("]")[1];
						middleNameValue = parseInt(middleNameValue)+1;
						var newNameValue = preNameValue+"["+middleNameValue+"]"+postNameValue;
						$input.attr("name",newNameValue);
					}else{//td  input
						/**
						 * xsyddzhibs[0].spbm
						 * xsyddzhibs[0].spbm-->xsyddzhibs,0].spbm,通过split[
						 * 0].spbm-->0,spbm,通过split]
						 */
						var $input = $(this).children("input");
						var oldNameValue = $input.attr("name");//原来的name属性的值
						var preNameValue = oldNameValue.split("[")[0]; //xsyddzhibs
						var middleNameValue = oldNameValue.split("[")[1].split("]")[0];
						var postNameValue = oldNameValue.split("[")[1].split("]")[1];
						middleNameValue = parseInt(middleNameValue)+1;
						var newNameValue = preNameValue+"["+middleNameValue+"]"+postNameValue;
						$input.attr("name",newNameValue);
					}
				});
				//给tr做一个克隆
				$("#right_center table").append(scmUtils.business.add.divOpt.trClone);
				$("#menu").hide();
			},
			/**
			 * 给右键菜单添加click事件
			 */
			rMenuClick:function(){
				$("#addRow").unbind("click");
				$("#addRow").bind("click",function(){
					scmUtils.business.add.addRow();
				});
			},
			/**
			 * 当鼠标移出右键菜单的时候，隐藏右键菜单
			 */
			hideRMenu:function(){
				$("#menu").hover(function(){
					
				},function(){//移出该区域触发的事件
					$(this).hide();
				});
			},
			/**
			 * 显示右键菜单
			 */
			showRMenu:function(e){
				$("#menu").css("left", e.clientX - 50);
        		$("#menu").css("top", e.clientY - 50);
       			$("#menu").show();
			},
			/**
			 * 给子表的行号添加右键事件
			 */
			addHhContextMenu:function(){
				$("body").delegate("td[item='hh']","contextmenu",function(e){
					scmUtils.business.add.showRMenu(e);
					return false;
				})
			},
			/**
			 * 弹出的div的操作
			 */
			divOpt:{
				tr:'',
				trClone:'',//对tr的克隆
				/**
				 * 显示div
				 */
				showDiv:function(){
					$("#seek").show();
					$.fn.GridPanel.createTable({
						url:'productAction_showProduct.action',
						fields:$("#seek *[item]")
					});
				},
				/**
				 * 获取选中的radio,把radio所在的那行的值填充到主表相应的行对应的列中
				 */
				fillValueToField:function(){
					var checkedRadio = $(":radio:checked");//被选中的radio
					var divTDS = checkedRadio.parent().siblings("td");//被选中的radio所在的td的兄弟节点
					//要回显的数据所在的tr
					var $tr = scmUtils.business.add.divOpt.tr;
					$.each(divTDS,function(){//遍历每一个divTDS
						var itemValue = $(this).attr("item");//正在遍历的每一个td的item属性的值
						if(itemValue=="spmc"){
							$tr.children("td[item='"+itemValue+"']").children("div").children("input").attr("value",$(this).text());
						}else{
							$tr.children("td[item='"+itemValue+"']").children("input").attr("value",$(this).text());
						}
					});
					$("#seek").hide();
				}
			},
			
			divProductFrame:{
				/**
			 	  * 点击商品名称的查询，弹出一个div框
			 	*/
				divProdctFrameEvent:function(){
					$(".searRR").unbind("click");
					$(".searRR").bind("click",function(){
						/**
						 * 克隆div(id为seek)
						 */
						scmUtils.business.add.divOpt.trClone = $(this).parent().parent().parent().clone(true);
						/*
						 * 在弹出div框以后，要选择某一个radio,然后把选择的数据回显到子表中，所以
						 * 必须确定子表中的某一行
						 */
						scmUtils.business.add.divOpt.showDiv();
						//找到要回显到子表中的数据的那一行
						scmUtils.business.add.divOpt.tr = $(this).parent().parent().parent();
					});		
				},
				/**
				 * 给弹出的div框的确定按钮添加click事件
				 */
				divProductFrameSureEvent:function(){
					$(".btn").unbind("click");
					$(".btn").bind("click",function(){
						scmUtils.business.add.divOpt.fillValueToField();
						/**
						 * 移除id为seek的div
						 */
						$("#seek").remove();
						return false;
					});
				}
			}
		},
		/**
		 * 当点击主表中的某一行的处理逻辑
		 */
		getZhibByZhuID:function(){
			var zhuid = $(this).attr("id");
			/**
			 * 把当前点击的主表中的某一行的主表ID赋值给<s:hidden name="query_zhib.xsyddzhubid"></s:hidden>
			 * 当点击子表中的分页的时候，把主表中该行的id的值传递到后台
			 */ 
			$("input[name='query_zhib.xsyddzhubid']").attr("value",zhuid);
			window.location.href = $("body").data("url")+zhuid;
		},
        /**
         * 给主表中的查询添加click事件
         */
        zhubTRClick: function(){//当点击主表中的某一行的时候，根据主表id加载子表
            $("tr[field='item_zhub']").unbind("click");
            $("tr[field='item_zhub']").bind("click", function(){
            	scmUtils.business.getZhibByZhuID.call(this);
            });
        },
		/**
		 * 业务模块关于分页的事件
		 */
		disPage:{
			/**
			 * 点击主表分页的上一页、下一页、首页、尾页要做的事情
			 */
			zhubLinkHref:function(){
				/**
				 * 获取到点击的那一页
				 */
				var currentPage = $(this).attr("param");
				//把当前页赋值给分页控件的表单元素
				$("#pageNo").attr("value",currentPage);
				document.forms[0].submit();
			},
			/**
			 * 点击子表分页的上一页、下一页、首页、尾页要做的事情
			 */
			zhibLinkHref:function(){
				/**
				 * 获取到点击的那一页
				 */
				var currentPage = $(this).attr("param");
				//把当前页赋值给分页控件的表单元素
				$("#pageNo_zhib").attr("value",currentPage);
				document.forms[0].submit();
			},
			/**
			 * 主表的分页的事件
			 */
			zhubDispageEvent:function(){
				/**
				 * 首页
				 */
				$("input[flag='zhub_firstPage']").unbind("click");
				$("input[flag='zhub_firstPage']").bind("click",function(){
					if ($(this).attr("param") == "0") {
                    	alert("已经是第一页了");
                	}else{
						scmUtils.business.disPage.zhubLinkHref.call(this);
					}
				});
				/**
				 * 上一页
				 */
				$("input[flag='zhub_prePage']").unbind("click");
				$("input[flag='zhub_prePage']").bind("click",function(){
					
					scmUtils.business.disPage.zhubLinkHref.call(this);
				});
				/**
				 * 下一页
				 */
				$("input[flag='zhub_nextPage']").unbind("click");
				$("input[flag='zhub_nextPage']").bind("click",function(){
					scmUtils.business.disPage.zhubLinkHref.call(this);
					
				});
				/**
				 * 尾页
				 */
				$("input[flag='zhub_lastPage']").unbind("click");
				$("input[flag='zhub_lastPage']").bind("click",function(){
					scmUtils.business.disPage.zhubLinkHref.call(this);
				});
			},
			/**
			 * 子表的分页的事件
			 */
			zhibDispageEvent:function(){
				/**
				 * 首页
				 */
				$("input[flag='zhib_firstPage']").unbind("click");
				$("input[flag='zhib_firstPage']").bind("click",function(){
					
				});
				/**
				 * 上一页
				 */
				$("input[flag='zhib_prePage']").unbind("click");
				$("input[flag='zhib_prePage']").bind("click",function(){
					
				});
				/**
				 * 下一页
				 */
				$("input[flag='zhib_nextPage']").unbind("click");
				$("input[flag='zhib_nextPage']").bind("click",function(){
					scmUtils.business.disPage.zhibLinkHref.call(this);
				});
				/**
				 * 尾页
				 */
				$("input[flag='zhib_lastPage']").unbind("click");
				$("input[flag='zhib_lastPage']").bind("click",function(){
					
				});
			}
		}
    }
}