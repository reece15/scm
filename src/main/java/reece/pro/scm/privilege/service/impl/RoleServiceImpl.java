package reece.pro.scm.privilege.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.base.service.impl.BaseServiceImpl;
import reece.pro.scm.domain.privilege.Role;
import reece.pro.scm.privilege.dao.RoleDao;
import reece.pro.scm.privilege.service.RoleService;

/**
 * @filename RoleServiceImpl.java
 * @author Reece
 * @description  
 * @date 2016-3-29下午7:11:42
 * @version 
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	
	@Resource(name="roleDao")
	private RoleDao roleDao;
	@Override
	public BaseDao<Role> getBaseDao() {
		return this.roleDao;
	}
	@Override
	public Role getRoleByName(String name) {
		return this.roleDao.getRoleByName(name);
	}
	@Override
	public Collection<Role> getRoleByUid(Long uid) {
		return this.roleDao.getRoleByUid(uid);
	}
	

}
