package reece.pro.scm.privilege.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import reece.pro.scm.basedata.dao.DepartmentDao;
import reece.pro.scm.domain.basedata.Department;
import reece.pro.scm.domain.privilege.Menuitem;
import reece.pro.scm.domain.privilege.Role;
import reece.pro.scm.privilege.dao.MenuItemDao;
import reece.pro.scm.privilege.dao.RoleDao;
import reece.pro.scm.query.basedata.DepartmentQuery;
import reece.pro.scm.test.util.SpringUtils;

/**
 * @filename DaoTest.java
 * @author Reece
 * @description  
 * @date 2016-3-29下午7:22:50
 * @version 
 */
public class DaoTest extends SpringUtils{
	@Test
	public void testFindEntry(){
		RoleDao dao = (RoleDao) applicationContext.getBean("roleDao");
		Collection<Role> roles = dao.findEntry();
		for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			System.out.println(role);
		}
	}
	@Test
	public void testMenuFindEntry(){
		MenuItemDao dao = (MenuItemDao) applicationContext.getBean("menuitemDao");
		Collection<Menuitem> roles = dao.findEntry();
		for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
			Menuitem menuitem = (Menuitem) iterator.next();
			System.out.println(menuitem);
		}
	}
}
