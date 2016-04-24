package reece.pro.scm.domain.privilege;

import java.io.Serializable;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * @filename Privilege.java
 * @author Reece
 * @description  
 * @date 2016-3-30下午9:38:30
 * @version 
 */
public class Privilege implements Serializable {
	private Long id;
	private String description;
	private String name;
	private Long pid;
	private Boolean isParent;
	private String type;//"1"表示菜单   "2"表示页面上的操作的元素
	private String icon;
	private String url;
	private String target;
	private Boolean checked;//设置是否被选中
	private Set<Role> roles;
	
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	//在本对象转化成json字符串的时候，该注解这么写可以忽略该属性 roles
	@JSON(serialize=false)
	public Set<Role> getRoles() {
		return roles;
	}
	
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Privilege [id=" + id + ", description=" + description
				+ ", name=" + name + ", pid=" + pid + ", isParent=" + isParent
				+ ", type=" + type + ", icon=" + icon + ", url=" + url
				+ ", target=" + target + "," + roles + "]";
	} 
}
