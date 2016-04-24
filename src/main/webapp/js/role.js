var roletree = {
    /**
     * 存放数据
     */
    data: {
        treeNode: '',
        zTreePlugin: ''
    },
    setting: {
        isSimpleData: true,
        treeNodeKey: "rid",
        treeNodeParentKey: "pid",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        },
        callback: {//回调函数
            rightClick: function(event, treeId, treeNode){
                roletree.data.treeNode = treeNode;
                roletree.showRMenu(event.clientX, event.clientY);
            }
        }
    },
    loadRoleTree: function(){
        $.post("roleAction_showRoleTree.action", null, function(data){
            roletree.data.zTreePlugin = $("#roleTree").zTree(roletree.setting, data);
        });
    },
    /**
     * 增加角色
     */
    addRole: function(){
        var roleName = window.prompt("请输入角色的名称");
        if (roleName) {
            /**
             * 在增加一个角色之前，先判断该角色的名字是否可用
             */
            $.post("roleAction_showRoleByName.action", {
                name: roleName
            }, function(data){
                if (data == "1") {//可用
                    var parameter = {
                        name: roleName,
                        pid: roletree.data.treeNode.rid, //新增加的节点的父节点就是当前的点击的节点,
                        isParent: false
                    };
                    $.post("roleAction_add.action", parameter, function(data1){
                        var newNode = {
                            rid: data1.rid,
                            name: roleName,
                            pid: roletree.data.treeNode.rid,
                            isParent: false
                        };
                        /**
                         * roletree.data.zTreePlugin是zTree函数运行后的返回值
                         * oletree.data.treeNode父节点
                         */
                        roletree.data.zTreePlugin.addNodes(roletree.data.treeNode, newNode, true);
                    });
                }else{
					alert("已经存在该角色了");
				}
            });
        }
    },
    
    /**
     * 删除角色
     */
    deleteRMenu:function(x, y){
    	//TODO 把数据库中的数据删掉
    	if(window.confirm("您确认要删除吗？")){
    		$.post("roleAction_deleteRole.action", {
        		rid:roletree.data.treeNode.rid
        	},function(data){
        		roletree.data.zTreePlugin.removeNode(roletree.data.treeNode);
        	});
        	//TODO 把前端的节点删掉
    	}
    	
    },
    /**
     * 更新
     */
    updateRole:function(){
    	var roleName = window.prompt("请填入修改名称", roletree.data.treeNode.name);
    	if(roletree.data.zTreePlugin.getNodeByParam("name", roleName)){
    		alert("对不起该名称已存在");
    	}else{
    		$.post("roleAction_updateRole.action", {
    			rid:roletree.data.treeNode.rid,
    			name:roleName
    				},function(data){
    					//获取当前点击的节点
    					var node = roletree.data.zTreePlugin.getNodeByParam("rid", roletree.data.treeNode.rid);
    					//修改其name的值
    					node.name = roleName;
    					//刷新ztree
    					roletree.data.zTreePlugin.refresh();
    					
    				});
    	}
    },
    
    /**
     * 显示右键菜单
     */
    showRMenu: function(x, y){
        $("#rMenu ul").show();
        $("#rMenu").css({
            "top": y + "px",
            "left": x + "px",
            "display": "block"
        });
    },
    /**
     * 初始化事件
     */
    init: {
        initEvent: function(){
            /**
             * 添加角色事件
             */
            $("#addRole").unbind("click");
            $("#addRole").bind("click", function(){
                roletree.addRole();
            });
            
            /**
             * 修改角色事件
             */
            $("#updateRole").unbind("click");
            $("#updateRole").bind("click", function(){
            	roletree.updateRole();
            });
            
            /**
             * 删除角色事件
             */
            $("#deleteRole").unbind("click");
            $("#deleteRole").bind("click", function(){
            	roletree.deleteRMenu();
            	$("#rMenu").hide();
            });
        }
    }
};

$().ready(function(){
    roletree.loadRoleTree();
    $("#rMenu").hover(function(){//进入#rMenu区域的时候做的事情
    }, function(){//出来该区域的时候做的事情
        $("#rMenu").hide();
    });
    //初始化事件
    roletree.init.initEvent();
});
