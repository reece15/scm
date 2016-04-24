package reece.pro.scm.privilege.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import reece.pro.scm.base.dao.impl.BaseDaoImpl;
import reece.pro.scm.domain.privilege.Menuitem;
import reece.pro.scm.domain.privilege.Privilege;
import reece.pro.scm.privilege.dao.MenuItemDao;
import reece.pro.scm.query.BaseQuery;
import reece.pro.scm.query.PageResult;

/**
 * @filename MenuItemDaoImol.java
 * @author Reece
 * @description  
 * @date 2016-3-29下午7:05:15
 * @version 
 */
@Repository("menuitemDao")
public class MenuItemDaoImol extends BaseDaoImpl<Menuitem> implements MenuItemDao {
	@Override
	public Collection<Menuitem> getMenuitemTreeByUid(Long uid) {
		return null;
	}

	@Override
	public Collection<Menuitem> getFunctionByUid(Long uid) {
		return null;
	}

}
