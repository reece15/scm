package reece.pro.scm.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.base.service.impl.BaseServiceImpl;
import reece.pro.scm.basedata.dao.DepartmentDao;
import reece.pro.scm.basedata.dao.UserDao;
import reece.pro.scm.basedata.service.UserService;
import reece.pro.scm.domain.basedata.User;

/**
 * @filename UserServiceImpl.java
 * @author Reece
 * @description  
 * @date 2016-3-29上午12:16:32
 * @version 
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService<User>{
	
	@Resource(name="userDao")
	private UserDao<User> userDao; 
	
	@Override
	public BaseDao<User> getBaseDao() {
		return this.userDao;
	}

}
