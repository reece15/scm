package reece.pro.scm.login.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import reece.pro.scm.domain.basedata.User;
import reece.pro.scm.login.dao.LoginDao;

/**
 * @filename LoginImpl.java
 * @author Reece
 * @description  登录时 数据库库里查询是否存在这样的用户和密码
 * @version 
 */
@Repository("loginDao")
public class loginDaoImpl implements LoginDao {

	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	@Override
	public User checkUser(String userName, String password) {
		List<User> users = hibernateTemplate.find("from User where username=? and password=?", userName, password);
		if(users.size() == 0){
			return null;
		}else{
			return users.get(0);
		}
	}

}
