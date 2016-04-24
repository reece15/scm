package reece.pro.scm.privilege.action;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import reece.pro.scm.base.action.BaseAction;
import reece.pro.scm.basedata.service.UserService;
import reece.pro.scm.domain.basedata.User;
import reece.pro.scm.domain.privilege.Privilege;
import reece.pro.scm.domain.privilege.Role;
import reece.pro.scm.privilege.annotation.PrivilegeInfo;
import reece.pro.scm.privilege.service.RoleService;
import reece.pro.scm.query.basedata.UserQuery;
import reece.pro.scm.util.GlobalKey;

/**
 * @filename RoleAction.java
 * @author Reece
 * @description  
 * @date 2016-3-29下午7:17:47
 * @version 
 */
@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	@Resource(name="roleService")
	private RoleService roleService;
	private UserQuery baseQuery = new UserQuery();
	
	@Resource(name="userService")
	private UserService<User> userService;
	private Long uid;
	
	
	

	public String showRoleTree(){
		Collection<Role> roles = this.roleService.getEntries();
		ActionContext.getContext().getValueStack().push(roles);
		return SUCCESS;
	}
	public String showRoleByUid(){
		Collection<Role> roles = this.roleService.getRoleByUid(uid);
		ActionContext.getContext().getValueStack().push(roles);
		return SUCCESS;
	}
	public String add(){
		Role role = new Role();
		BeanUtils.copyProperties(this.getModel(), role);
		this.roleService.saveEnrty(role);
		ActionContext.getContext().getValueStack().push(role);
		return SUCCESS;
	}
	public String showRoleByName(){
		Role role = this.roleService.getRoleByName(this.getModel().getName());
		if(role == null){
			ActionContext.getContext().getValueStack().push(GlobalKey.ROLE_NAME_OK);
		}else{
			ActionContext.getContext().getValueStack().push(GlobalKey.ROLE_NAME_BAD);
		}
		return SUCCESS;
	}
	public String updateRole(){
		Role role = this.roleService.getEntryById(this.getModel().getRid());
		role.setName(this.getModel().getName());
		this.roleService.updateEntry(role);
		return SUCCESS;
	}
	public String deleteRole(){
		this.roleService.deleteEntryById(this.getModel().getRid());
		return SUCCESS;
	}
	public String showRoles(){
		Collection<Role> roles = this.roleService.getEntries();
		ActionContext.getContext().put("roles", roles);
		return listUI;
	}
	public String showUserList(){
		Collection<User> users = this.userService.getEntries();
		ActionContext.getContext().put("users", users);
		return listUI;
	}
	public String saveRole(){
		User user = this.userService.getEntryById(uid);
		Set<Role> roles = this.roleService.getEntriesByIds(this.checkedStr.split(","));
		user.setRoles(roles);
		this.userService.updateEntry(user);
		return SUCCESS;
	}
	
	private String checkedStr;
	
	
	
	public String getCheckedStr() {
		return checkedStr;
	}

	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	
}
