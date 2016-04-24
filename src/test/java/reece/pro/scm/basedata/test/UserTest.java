package reece.pro.scm.basedata.test;

import org.junit.Test;

import reece.pro.scm.basedata.service.UserService;
import reece.pro.scm.domain.basedata.Department;
import reece.pro.scm.domain.basedata.User;
import reece.pro.scm.query.PageResult;
import reece.pro.scm.query.basedata.UserQuery;
import reece.pro.scm.test.util.SpringUtils;

/**
 * @filename UserTest.java
 * @author Reece
 * @description  
 * @date 2016-3-29上午12:52:34
 * @version 
 */
public class UserTest extends SpringUtils{
	
	public void testSaveEntry() {
		UserService userService =  (UserService) applicationContext.getBean("userService");
		User user = new User();
		user.setEmail("364987@qq.com");
		user.setUsername("小觅");
		user.setDepartment(new Department(1, "1", "11"));
		userService.saveEnrty(user);
	}
	
	@Test
	public void testShowPageResult() {
		UserService userService =  (UserService) applicationContext.getBean("userService");
		UserQuery userQuery = new UserQuery();
		userQuery.setUser(new User());
		PageResult<User> pageResult = userService.getPageResult(userQuery);
		for(User user : pageResult.getRows()){
			System.out.println(user);
		}
	}
}
