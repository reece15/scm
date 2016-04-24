package reece.pro.scm.privilege.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.base.service.impl.BaseServiceImpl;
import reece.pro.scm.domain.privilege.Privilege;
import reece.pro.scm.privilege.dao.PrivilegeDao;
import reece.pro.scm.privilege.service.PrivilegeService;

/**
 * @filename PrivilegeServiceImpl.java
 * @author Reece
 * @description  
 * @version 
 */
@Service("privilegeService")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements
		PrivilegeService {

	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;
	
	@Override
	public BaseDao<Privilege> getBaseDao() {
		return this.privilegeDao;
	}

	@Override
	public Collection<Privilege> getPrivilegesByRoleId(Long id) {
		return privilegeDao.getPrivilegesByRid(id);
	}

	@Override
	public Collection<Privilege> getMenuitemTreeByUid(Long uid) {
		return privilegeDao.getMenuitemTreeByUid(uid);
	}

	@Override
	public Collection<Privilege> getFunctionTreeByUid(Long uid) {
		return privilegeDao.getFunctionTreeById(uid);
	}

}
