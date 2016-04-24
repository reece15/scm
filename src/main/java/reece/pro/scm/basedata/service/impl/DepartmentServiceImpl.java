package reece.pro.scm.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.base.service.impl.BaseServiceImpl;
import reece.pro.scm.basedata.dao.DepartmentDao;
import reece.pro.scm.basedata.service.DepartmentService;
import reece.pro.scm.domain.basedata.Department;

/**
 * @filename DepartmentImpl.java
 * @author Reece
 * @description  
 * @date 2016-3-27下午3:09:21
 * @version 
 */
@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao; 
	@Override
	public BaseDao<Department> getBaseDao() {
		return this.departmentDao;
	}
	
}
