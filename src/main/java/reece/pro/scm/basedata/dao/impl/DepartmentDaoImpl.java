package reece.pro.scm.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import reece.pro.scm.base.dao.impl.BaseDaoImpl;
import reece.pro.scm.basedata.dao.DepartmentDao;
import reece.pro.scm.domain.basedata.Department;

/**
 * 
 * @author Reece
 * @description 
 * @date 2016-3-26下午7:11:21
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{
	
}
