package reece.pro.scm.privilege.service;

import java.io.Serializable;
import java.util.Collection;

import reece.pro.scm.base.service.BaseService;
import reece.pro.scm.domain.privilege.Privilege;

/**
 * @filename PrivilegeService.java
 * @author Reece
 * @description  
 * @date 2016-3-30下午10:10:18
 * @version 
 */
public interface PrivilegeService extends BaseService<Privilege> {
	public Collection<Privilege> getPrivilegesByRoleId(Long id);
	public Collection<Privilege> getMenuitemTreeByUid(Long uid);
	public Collection<Privilege> getFunctionTreeByUid(Long uid);
}
