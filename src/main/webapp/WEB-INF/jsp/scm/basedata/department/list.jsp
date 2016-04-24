<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/scm/common/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" ></meta>
<title>列表</title>
<script type="text/javascript">
	$().ready(function(){
	    //设置分页要跳转到的url
		$("body").data("url","departmentAction_showPageResult.action");
		//声明分页的事件
		scmUtils.basedata.initEvent();
		scmUtils.basedata.deleteObj.deleteObjFunction({
			id:'deleteSome',
			checkboxname:'dids',
			controlCheckBox:'controlCheckBox',
			url: 'departmentAction_deleteDepartments.action',
			delName:'delOne'
		});
		scmUtils.basedata.updateObj.updateObjFunction({
			url:'departmentAction_updateUI.action',
			id: 'depId'
		});
	});
</script>
</head>
<body>
<table id="userwrap">
	
	<tr class="user">
        <td class="right">
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="900" style=" overflow:auto; height:40px;">
                <tr class="one" height="20">
                	<td class="btn" align="left"><input type="button" value="删除" id="deleteSome"/></td>
                </tr>
                <tr class="one" height="20">
                	<td><input type="checkbox" id="controlCheckBox"/></td>
                    <td width="300">部门名称</td>
                    <td width="300">描述</td>
					<td width="300">操作</td>
                </tr>
                	<s:iterator  value="#departments.rows">
	                <tr align="center">
	                   <td><input type="checkbox" name="dids" value="${depId}"></input></td>
	                   <td><s:property value="name"/></td>
	                   <td><s:property value="description"/></td>
					   <td class="btn" align="center">
					   	<input type="button" value="修改"></input>
					    <input type="button" name="delOne" value="删除"></input>
					   </td>
	                </tr>
	               </s:iterator>
             </table>
            <p style="width:900px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" flag="firstPage" value="首页"/>&nbsp;
		<input type="button" flag="prePage" param="${departments.currentPage-1}" value="上一页" />&nbsp;
		<input type="button" param="${departments.currentPage+1}" flag="nextPage" last="${departments.totalPages}" value="下一页"/>&nbsp;
		<input type="button" param="${departments.totalPages}" flag="lastPage" value="尾页"/>&nbsp;
		<span>
			转到第
			<input name="basedataQuery.currentPage" id="pageNo" type="text" value="${basedataQuery.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />
			页
		</span>
			&nbsp;&nbsp;
		<input type="button" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${departments.totalRows}条记录，当前第 ${departments.currentPage}/${departments.totalPages}页</p>
        </td>
    </tr>
</table>
<div>
    <a href="departmentAction_addUI.action"><img src="${pageContext.request.contextPath}/images/createNew.png" /></a>
</div>
</body>
</html>