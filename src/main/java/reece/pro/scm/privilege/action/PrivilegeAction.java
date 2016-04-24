package reece.pro.scm.privilege.action;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import reece.pro.scm.base.action.BaseAction;
import reece.pro.scm.domain.basedata.User;
import reece.pro.scm.domain.privilege.Privilege;
import reece.pro.scm.domain.privilege.Role;
import reece.pro.scm.privilege.annotation.PrivilegeInfo;
import reece.pro.scm.privilege.service.PrivilegeService;
import reece.pro.scm.privilege.service.RoleService;

/**
 * @filename PrivilegeAction.java
 * @author Reece
 * @description  
 * @version 
 */
@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Privilege> {

	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	@Resource(name="roleService")
	private RoleService roleService;
	
	private Long rid;
	private String checkedStr; 
	
	
	public String showPrivilegeTree() throws InterruptedException{
		Collection<Privilege> privileges = this.privilegeService.getPrivilegesByRoleId(this.getRid());
		ActionContext.getContext().getValueStack().push(privileges);
		Thread.sleep(1000L);
		return SUCCESS;
	}
	
	/**
	 * 保存用户设置的权限关系
	 * @author Reece
	 * @description 
	 * @return
	 */
	public String savePrivilege(){
		Role role = this.roleService.getEntryById(rid);
		if(this.checkedStr.length() == 0){
			role.setPrivileges(null);
		}else{
			Set<Privilege> privileges = this.privilegeService.getEntriesByIds(this.checkedStr.split(","));
			role.setPrivileges(privileges);
		}
		this.roleService.updateEntry(role);
		return SUCCESS;
	}
	/**
	 * 根据用户登录的id展示左界面的权限树
	 * @author Reece
	 * @description 
	 * @return
	 */
	public String showMenuitemTreeByUid() {
		User user = (User) this.getSession().getAttribute("user");
		Collection<Privilege> privileges = this.privilegeService.getMenuitemTreeByUid(user.getUid());
		ActionContext.getContext().getValueStack().push(new HashSet<Privilege>(privileges));
		return SUCCESS;
	}
	
	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getCheckedStr() {
		return checkedStr;
	}

	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}

	
	
	
}
