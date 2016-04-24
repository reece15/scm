package reece.pro.scm.basedata.action;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import reece.pro.scm.base.action.BaseAction;
import reece.pro.scm.basedata.service.DepartmentService;
import reece.pro.scm.domain.basedata.Department;
import reece.pro.scm.privilege.annotation.PrivilegeInfo;
import reece.pro.scm.query.PageResult;
import reece.pro.scm.query.basedata.DepartmentQuery;
import sun.tools.tree.ThisExpression;



/**
 * @filename DepartmentAction.java
 * @author Reece
 * @description 部门action
 * @date 2016-3-27下午4:18:41
 * @version 
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	private DepartmentQuery baseQuery = new DepartmentQuery();
	private int currentPage;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 
	 * @author Reece
	 * @description 显示结果集
	 * @date 2016-3-28下午4:19:31
	 * @return
	 */
	@PrivilegeInfo(name="部门查询")
	public String showPageResult(){
		baseQuery.setCurrentPage(currentPage);
		System.out.println(baseQuery.getCurrentPage());
		baseQuery.setDepartment(new Department());
		PageResult<Department> departments =  this.departmentService.getPageResult(baseQuery);
		ActionContext.getContext().put("departments", departments);
		return listUI; 
	}
	
	/**
	 * 
	 * @author Reece
	 * @description 删除信息 
	 * @date 2016-3-28下午4:19:15
	 * @return
	 */
	@PrivilegeInfo(name="部门删除")
	public String deleteDepartments(){
		String[] dids = this.getCheckedStr().split(",");
		this.departmentService.deleteEntriesByIds(dids);
		return action2action;
	}
	
	/**
	 * 
	 * @author Reece
	 * @description 添加信息
	 * @date 2016-3-28下午4:18:59
	 * @return
	 */
	@PrivilegeInfo(name="部门增加")
	public String addUI(){
		return addUI;
	}
	@PrivilegeInfo(name="部门增加")
	public String add(){
		Department department = new Department();
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.saveEnrty(department);
		return action2action;
	}
	@PrivilegeInfo(name="部门修改")
	public String updateUI(){
		System.out.println(this.getModel().getDepId());
		Department department = this.departmentService.getEntryById(this.getModel().getDepId());
		System.out.println(department);
		ActionContext.getContext().getValueStack().push(department);
		return updateUI;
	}
	@PrivilegeInfo(name="部门修改")
	public String update(){
		Department department = this.departmentService.getEntryById(this.getModel().getDepId());
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.updateEntry(department);
		return "chain";
	}
}
