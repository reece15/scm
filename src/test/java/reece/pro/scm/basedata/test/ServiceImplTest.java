package reece.pro.scm.basedata.test;

import org.junit.Test;

import reece.pro.scm.basedata.dao.DepartmentDao;
import reece.pro.scm.basedata.service.DepartmentService;
import reece.pro.scm.domain.basedata.Department;
import reece.pro.scm.test.util.SpringUtils;

/**
 * @filename ServiceImplTest.java
 * @author Reece
 * @description  
 * @date 2016-3-27下午3:49:10
 * @version 
 */
public class ServiceImplTest extends SpringUtils{
	@Test
	public void testSaveEntry() {
		DepartmentService departmentService =  (DepartmentService) applicationContext.getBean("departmentService");
		Department department = new Department();
		department.setDescription("testServiceSave");
		department.setName("testServiceSave");
		departmentService.saveEnrty(department);
	}
}
