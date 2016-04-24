package reece.pro.scm.privilege.test;



import org.junit.Test;

import reece.pro.scm.domain.privilege.Role;
import reece.pro.scm.privilege.dao.RoleDao;
import reece.pro.scm.privilege.service.RoleService;
import reece.pro.scm.test.util.SpringUtils;


public class RoleTest extends SpringUtils{
	@Test
	public void testSaveRole(){
		RoleService roleService = (RoleService)applicationContext.getBean("roleService");
		Role t = new Role();
		t.setIsParent(true);
		t.setName("CEO");
		t.setPid(0L);
		roleService.saveEnrty(t);
	}
	
	@Test
	public void testQueryRoleByName(){
		RoleDao roleDao = (RoleDao)applicationContext.getBean("roleDao");
		Role role = roleDao.getRoleByName("aaa");
		System.out.println(role);
	}
}
