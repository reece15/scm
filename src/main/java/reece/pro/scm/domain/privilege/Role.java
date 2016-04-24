package reece.pro.scm.domain.privilege;

import java.io.Serializable;
import java.util.Set;

import reece.pro.scm.domain.basedata.User;

/**
 * @filename Role.java
 * @author Reece
 * @description  权限管理规则
 * @date 2016-3-29下午5:59:56
 * @version 
 */
public class Role implements Serializable {
	/**
	 * 权限管理规则
	 */
	private Long rid;
	private Long pid;
	/**
	 * 规则名称
	 */
	private String name;
	
	/**
	 * 
	 */
	private Boolean isParent;
	/**
	 * 用户
	 */
	private Set<User> users;
	private Set<Privilege> privileges;
	private Boolean checked;//设置是否被选中
	
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", pid=" + pid + ", name=" + name
				+ ", isParent=" + isParent + ", " + "]";
	}
}
