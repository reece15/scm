package reece.pro.scm.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import reece.pro.scm.base.dao.impl.BaseDaoImpl;
import reece.pro.scm.basedata.dao.UserDao;
import reece.pro.scm.domain.basedata.User;

/**
 * @filename UserDaoImpl.java
 * @author Reece
 * @description  
 * @date 2016-3-29上午12:14:46
 * @version 
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User>{
	
}
