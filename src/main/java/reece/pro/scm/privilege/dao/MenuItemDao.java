package reece.pro.scm.privilege.dao;

import java.util.Collection;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.domain.privilege.Menuitem;
import reece.pro.scm.domain.privilege.Privilege;

/**
 * @filename MenuItemDao.java
 * @author Reece
 * @description  
 * @date 2016-3-29下午6:57:21
 * @version 
 */
public interface MenuItemDao extends BaseDao<Menuitem> {
	public Collection<Menuitem> getMenuitemTreeByUid(Long uid);

	public Collection<Menuitem> getFunctionByUid(Long uid);
}
