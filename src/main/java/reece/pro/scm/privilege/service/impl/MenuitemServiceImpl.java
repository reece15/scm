package reece.pro.scm.privilege.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.base.service.impl.BaseServiceImpl;
import reece.pro.scm.domain.privilege.Menuitem;
import reece.pro.scm.privilege.dao.MenuItemDao;
import reece.pro.scm.privilege.service.MenuitemService;

/**
 * @filename MenuitemServiceImpl.java
 * @author Reece
 * @description  
 * @date 2016-3-29下午7:12:52
 * @version 
 */
@Service("menuitemService")
public class MenuitemServiceImpl extends BaseServiceImpl<Menuitem> implements MenuitemService {
	
	@Resource(name="menuitemDao")
	private MenuItemDao menuItemDao;
	
	@Override
	public BaseDao<Menuitem> getBaseDao() {
		return this.menuItemDao;
	}
	
	

}
