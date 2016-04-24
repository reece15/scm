package reece.pro.scm.login.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

import reece.pro.scm.domain.basedata.User;
import reece.pro.scm.login.dao.LoginDao;
import reece.pro.scm.login.dao.impl.loginDaoImpl;
import reece.pro.scm.test.util.SpringUtils;

/**
 * @filename TestLogin.java
 * @author Reece
 * @description  
 * @version 
 */
public class TestLogin extends SpringUtils{
	@Test
	public void testLogin(){
		LoginDao loginDao = (LoginDao) applicationContext.getBean("loginDao");
		User user = loginDao.checkUser("admin", "111111");
		System.err.println(user);
	}
}
