package reece.pro.scm.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reece.pro.scm.domain.basedata.User;
import reece.pro.scm.login.dao.LoginDao;
import reece.pro.scm.login.service.LoginService;

/**
 * @filename LoginServiceImpl.java
 * @author Reece
 * @description  
 * @version 
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Resource(name="loginDao")
	private LoginDao loginDao;
	
	@Override
	public User checUser(String userName, String password) {
		return loginDao.checkUser(userName, password);
	}

}
