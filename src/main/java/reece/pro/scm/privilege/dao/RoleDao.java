package reece.pro.scm.privilege.dao;

import java.util.Collection;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.domain.privilege.Role;

/**
 * @filename RoleDao.java
 * @author Reece
 * @description  
 * @date 2016-3-29下午6:56:44
 * @version 
 */
public interface RoleDao extends BaseDao<Role> {
	public Role getRoleByName(final String name);
	public Collection<Role> getRoleByUid(Long uid);
}
