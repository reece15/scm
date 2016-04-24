package reece.pro.scm.privilege.dao.impl;

import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import reece.pro.scm.base.dao.impl.BaseDaoImpl;
import reece.pro.scm.domain.privilege.Privilege;
import reece.pro.scm.privilege.dao.PrivilegeDao;

/**
 * @filename PrivilegeDaoImpl.java
 * @author Reece
 * @description  
 * @version 
 */
@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao {

	@Override
	/**
	 * 得到所有权限
	 * 得到该角色所能访问的所有权限
	 * 把用户所能访问的所有权限设置checked为true
	 */
	public Collection<Privilege> getPrivilegesByRid(Long rid) {
		Collection<Privilege> privileges = this.hibernateTemplate.find("from Privilege");
		Collection<Privilege> userPrivileges = this.hibernateTemplate
				.find("from Privilege p inner join fetch p.roles r where r.id=?", rid);
		for (Privilege p : userPrivileges) {
			for (Privilege userp : userPrivileges) {
				if(p.getId().longValue() == userp.getId().longValue()){
					p.setChecked(true);
				}
			}
		}
		
		return privileges;
	}

	@Override
	public Collection<Privilege> getMenuitemTreeByUid(Long uid) {
		
		if(uid == 1){
			return this.hibernateTemplate.find("from Privilege");
		}else{
			return this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r inner join fetch r.users u where u.uid=?", uid);
		}
	}

	@Override
	public Collection<Privilege> getFunctionTreeById(Long uid) {
		if(uid == 1){
			return this.hibernateTemplate.find("from Privilege where type='2'");
		}else{
			return this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r inner join fetch r.users u where u.uid=? and p.type='2'", uid);
		}
	}

}
