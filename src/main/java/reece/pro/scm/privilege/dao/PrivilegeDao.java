package reece.pro.scm.privilege.dao;

import java.util.Collection;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.domain.privilege.Privilege;


/**
 * @filename privilege.java
 * @author Reece
 * @description  
 * @version 
 */
public interface PrivilegeDao extends BaseDao<Privilege> {
	
	/**
	 * 得到一个用户所能访问的所有权限
	 * @author Reece
	 * @description 
	 * @param rid
	 * @return
	 */
	public Collection<Privilege> getPrivilegesByRid(Long rid);
	
	/**
	 * 得到一个用户能够访问的菜单权限
	 * @author Reece
	 * @description 
	 * @param uid
	 * @return
	 */
	
	public Collection<Privilege> getMenuitemTreeByUid(Long uid);
	/**
	 * 得到一个用户能够访问的功能权限
	 * @author Reece
	 * @description 
	 * @param uid
	 * @return
	 */
	public Collection<Privilege> getFunctionTreeById(Long uid);
}
