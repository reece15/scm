package reece.pro.scm.basedata.test;

import org.junit.Test;


import reece.pro.scm.basedata.action.DepartmentAction;
import reece.pro.scm.test.util.SpringUtils;

/**
 * @filename ActionImplTest.java
 * @author Reece
 * @description  
 * @date 2016-3-27下午4:49:01
 * @version 
 */
public class ActionImplTest extends SpringUtils{
	
	@Test
	public void testDepartmentAction(){
		DepartmentAction departmentAction = (DepartmentAction) applicationContext.getBean("departmentAction");
	}
}
