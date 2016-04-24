package reece.pro.scm.login.service;

import reece.pro.scm.domain.basedata.User;

/**
 * @filename LoginService.java
 * @author Reece
 * @description  登录逻辑
 * @version 
 */
public interface LoginService {
	/**
	 * 
	 * @author Reece
	 * @description  登录逻辑
	 * @param userName用户名
	 * @param password 密码
	 * @return 找到的用户
	 */
	public User checUser(String userName, String password);
}
