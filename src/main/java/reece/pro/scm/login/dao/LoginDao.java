package reece.pro.scm.login.dao;

import reece.pro.scm.domain.basedata.User;

/**
 * @filename LoginDao.java
 * @author Reece
 * @description  登录时 数据库库里查询是否存在这样的用户和密码
 * @version 
 */
public interface LoginDao {
	/**
	 * 
	 * @author Reece
	 * @description   登录时 数据库库里查询是否存在这样的用户和密码
	 * @param userName 用户名
	 * @param password 用户密码
	 * @return 找到的用户对象 没有则返回null
	 */
	public User checkUser(String userName, String password);
}
