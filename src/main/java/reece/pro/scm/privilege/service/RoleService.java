package reece.pro.scm.privilege.service;

import java.util.Collection;

import reece.pro.scm.base.service.BaseService;
import reece.pro.scm.domain.privilege.Role;

/**
 * @filename RoleService.java
 * @author Reece
 * @description  
 * @date 2016-3-29下午7:10:15
 * @version 
 */
public interface RoleService extends BaseService<Role> {
	/**
	 * 通过名字得到规则
	 * @author Reece
	 * @description 
	 * @param name
	 * @return
	 */
	public Role getRoleByName(String name);
	/**
	 * 通过id得到规则
	 * @author Reece
	 * @description 
	 * @param uid
	 * @return
	 */
	public Collection<Role> getRoleByUid(Long uid);
}
