package reece.pro.scm.domain.basedata;

import java.io.Serializable;
import java.util.Set;

public class Department implements Serializable{
	/**
	 * 
	 * 部门ID
	 */
	private long depId;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 部门说明
	 */
	private String description;
	
	/**
	 * 用户
	 */
	private Set<User> users;
	
	public Department() {
	}
	public Department(long depId, String name, String description) {
		super();
		this.depId = depId;
		this.name = name;
		this.description = description;
	}
	public long getDepId() {
		return depId;
	}
	public void setDepId(long depId) {
		this.depId = depId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		return "Department [depId=" + depId + ", name=" + name
				+ ", description=" + description + ", "  + "]";
	}
	
	
	
}
