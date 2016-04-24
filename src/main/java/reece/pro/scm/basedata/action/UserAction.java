package reece.pro.scm.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import reece.pro.scm.base.action.BaseAction;
import reece.pro.scm.basedata.service.DepartmentService;
import reece.pro.scm.basedata.service.UserService;
import reece.pro.scm.basedata.service.impl.UserServiceImpl;
import reece.pro.scm.domain.basedata.Department;
import reece.pro.scm.domain.basedata.User;
import reece.pro.scm.privilege.annotation.PrivilegeInfo;
import reece.pro.scm.query.PageResult;
import reece.pro.scm.query.basedata.UserQuery;

/**
 * @filename UserAction.java
 * @author Reece
 * @description  
 * @date 2016-3-29上午12:12:19
 * @version 
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	private UserQuery baseQuery = new UserQuery();
	private int currentPage;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	private Long depId;//页面上的部门id



	public Long getDepId() {
		return depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}
	
	@PrivilegeInfo(name="用户查询")
	public String showPageResult(){
		User user = new User();
		user.setDepartment(new Department());
		baseQuery.setCurrentPage(currentPage);
		baseQuery.setUser(user);
		PageResult<User> users = this.userService.getPageResult(baseQuery);
		ActionContext.getContext().put("users", users);
		return listUI;
	}
	@PrivilegeInfo(name="用户删除")
	public String deleteUsers(){
		String[] dids = this.getCheckedStr().split(",");
		this.userService.deleteEntriesByIds(dids);
		return action2action;
	}
	@PrivilegeInfo(name="用户增加")
	public String addUI(){
		Collection<Department> departments = this.departmentService.getEntries();
		ActionContext.getContext().put("departments", departments);
		return addUI;
	}
	@PrivilegeInfo(name="用户增加")
	public String add(){
		User user = new User();
		BeanUtils.copyProperties(this.getModel(), user);
		
		Department department = this.departmentService.getEntryById(this.depId);
		//建立用户与部门之间的关系
		user.setDepartment(department);
		
		this.userService.saveEnrty(user);
		return action2action;
	}
	@PrivilegeInfo(name="用户修改")
	public String updateUI(){
		/**
		 * 将user放入值栈
		 */
		User user = (User) this.userService.getEntryById(this.getModel().getUid());
		System.out.println(user);
		ActionContext.getContext().getValueStack().push(user);
		/**
		 * 将departments放入值栈
		 */
		Collection<Department> departments = this.departmentService.getEntries();
		ActionContext.getContext().put("departments", departments);
		
		
		return updateUI;
	}
	@PrivilegeInfo(name="用户修改")
	public String update(){
		User user = (User) this.userService.getEntryById(this.getModel().getUid());
		BeanUtils.copyProperties(this.getModel(), user);
		
		Department department = this.departmentService.getEntryById(this.depId);
		//建立用户与部门之间的关系
		user.setDepartment(department);
		
		this.userService.updateEntry(user);
		return "chain";
	}
	
	
}
