package reece.pro.scm.domain.privilege;

import java.io.Serializable;

/**
 * @filename Menuitem.java
 * @author Reece
 * @description  菜单实体类
 * @date 2016-3-29下午5:53:48
 * @version 
 */
public class Menuitem implements Serializable{
	/**
	 * 菜单id
	 */
	private Long mid;
	/**
	 * 父菜单Id
	 */
	private Long pid;
	/**
	 * 是否是父节点
	 */
	private Boolean isParent;
	
	/**
	 * 图片路径
	 */
	private String icon;

	/**
	 * 名字
	 */
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Menuitem [mid=" + mid + ", pid=" + pid + ", isParent="
				+ isParent + ", icon=" + icon + "]";
	}
	
}
