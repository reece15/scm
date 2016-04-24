package reece.pro.scm.domain.basedata;

import java.io.Serializable;
import java.util.Set;

import reece.pro.scm.domain.privilege.Role;

/**
 * @filename User.java
 * @author Reece
 * @description  
 * @date 2016-3-28下午11:51:57
 * @version 
 */
public class User implements Serializable{
	private String username;
	private Long uid;
	private String password;
	private String phone;
	private String email;
	private String sex;
	private Department department;
	private Set<Role> roles;
	
	
	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", uid=" + uid + ", password="
				+ password + ", phone=" + phone + ", email=" + email + ", sex="
				+ sex + ", " + "]";
	}
	
	
}
