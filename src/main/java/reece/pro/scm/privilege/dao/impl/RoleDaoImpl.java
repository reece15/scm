package reece.pro.scm.privilege.dao.impl;

import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import reece.pro.scm.base.dao.impl.BaseDaoImpl;
import reece.pro.scm.domain.privilege.Role;
import reece.pro.scm.privilege.dao.RoleDao;

/**
 * @filename RoleDaoImpl.java
 * @author Reece
 * @description  
 * @date 2016-3-29下午7:06:37
 * @version 
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public Role getRoleByName(final String name) {
		return this.hibernateTemplate.execute(new HibernateCallback<Role>() {

			@Override
			public Role doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("from Role where name=:name");
				query.setParameter("name", name);
				return (Role) query.uniqueResult();
			}
		});
	}

	@Override
	public Collection<Role> getRoleByUid(final Long uid) {
		Collection<Role> roles = this.hibernateTemplate.find("from Role");
		Collection<Role> userRoles = this.hibernateTemplate.
				find("from Role r inner join fetch r.users u where u.uid=?", uid);
		for (Role role : roles) {
			for (Role uRole : userRoles) {
				if(role.getRid().longValue() == uRole.getPid().longValue()){
					role.setChecked(true);
				}
			}
		}
		return roles;
	}

}
