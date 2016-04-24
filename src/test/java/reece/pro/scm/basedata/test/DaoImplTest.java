package reece.pro.scm.basedata.test;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.base.dao.impl.BaseDaoImpl;
import reece.pro.scm.basedata.dao.DepartmentDao;
import reece.pro.scm.domain.basedata.Department;
import reece.pro.scm.query.BaseQuery;
import reece.pro.scm.query.PageResult;
import reece.pro.scm.query.basedata.DepartmentQuery;
import reece.pro.scm.test.util.SpringUtils;




/**
 * @filename DaoImplTest.java
 * @author Reece
 * @description   测试类
 * @date 2016-3-26下午5:12:35
 * @version 1.0
 */
public class DaoImplTest extends SpringUtils{
	
	public void getCountTest() {
		BaseDao<Department> dao = (BaseDao<Department>) applicationContext.getBean("baseDao");
		DepartmentQuery departmentQuery = new DepartmentQuery();
		Department department = new Department();
		department.setName("试试");
		departmentQuery.setDepartment(department);
		int count = dao.getCount(departmentQuery);
		System.out.println(count);
	}
	@Test
	public void testFindResult(){
		DepartmentDao dao = (DepartmentDao) applicationContext.getBean("departmentDao");
		DepartmentQuery departmentQuery = new DepartmentQuery();
		departmentQuery.setPageSize(2);
		departmentQuery.setCurrentPage(2);
		Department department = new Department();
		
		departmentQuery.setDepartment(department);
		PageResult<Department> pageResult = dao.findPageResult(departmentQuery);
		for (Department dep: pageResult.getRows()) {
			System.out.println(dep.getDepId() + dep.getName() + dep.getDescription());
		}
	}
	@Test
	public void testFindEntry(){
		DepartmentDao dao = (DepartmentDao) applicationContext.getBean("departmentDao");
		DepartmentQuery departmentQuery = new DepartmentQuery();
		List<Department> list = (List<Department>) dao.findEntry();
		for (Department dep: list) {
			System.out.println(dep.getDepId() + dep.getName() + dep.getDescription());
		}
	}
	public void testSaveEntry() {
		DepartmentDao dao = (DepartmentDao) applicationContext.getBean("departmentDao");
		Department department = new Department();
		department.setDescription("testSave");
		department.setName("testSave");
		dao.saveEntry(department);
	}
	
	public void updateEntry(){
		DepartmentDao dao = (DepartmentDao) applicationContext.getBean("departmentDao");
		Department department = new Department();
		department.setDepId(4);
		department.setDescription("TESTUPDATE");
		department.setName("testSave");
		dao.updateEntry(department);
	}
	
	public void testDeleteEntriesByIDs(){
		System.out.println("Test testDeleteEntriesByIDs");
		DepartmentDao dao = (DepartmentDao) applicationContext.getBean("departmentDao");
		dao.deleteEntriesByIDs(new Integer[]{3,2});
	}
	
	public void testDeleteEntry(){
		System.out.println("Test testDeleteEntry");
		DepartmentDao dao = (DepartmentDao) applicationContext.getBean("departmentDao");
		dao.deleteEntry(4L);
	}
	@Test
	public void testGetEntriesByIds(){
		System.out.println("Test testGetEntriesByIds");
		DepartmentDao dao = (DepartmentDao) applicationContext.getBean("departmentDao");
		Set<Department> dSet = dao.getEntriesByIds(new Integer[]{1,2});
		for (Department department : dSet) {
			System.out.println(department.getDepId() + department.getDescription()+department.getName());
		}
	}
	@Test
	public void testGetEntryById(){
		System.out.println("Test testGetEntryById");
		DepartmentDao dao = (DepartmentDao) applicationContext.getBean("departmentDao");
		Department department = dao.getEntryById(2L);
		System.out.println(department.getDepId() + department.getDescription()+department.getName());
	}
}
