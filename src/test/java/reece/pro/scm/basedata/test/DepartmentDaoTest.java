package reece.pro.scm.basedata.test;

import org.junit.Test;

import reece.pro.scm.basedata.dao.DepartmentDao;
import reece.pro.scm.domain.basedata.Department;
import reece.pro.scm.query.basedata.DepartmentQuery;
import reece.pro.scm.test.util.SpringUtils;

/**
 * @filename DepartmentDaoTest.java
 * @author Reece
 * @description  
 * @date 2016-3-26下午7:26:07
 * @version 
 */
public class DepartmentDaoTest extends SpringUtils{
	@Test
	public void testGetCount(){
		DepartmentDao departmentDao = (DepartmentDao) applicationContext.getBean("departmentDao");
		DepartmentQuery departmentQuery = new DepartmentQuery();
		Department department = new Department();
		department.setName("试试");
		departmentQuery.setDepartment(department);
		int count = departmentDao.getCount(departmentQuery);
		System.out.println("Test depertmentDao:" + count);
	}
}
