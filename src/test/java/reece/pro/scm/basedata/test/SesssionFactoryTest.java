package reece.pro.scm.basedata.test;

import java.util.Arrays;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import reece.pro.scm.domain.basedata.Department;
import reece.pro.scm.test.util.SpringUtils;

public class SesssionFactoryTest extends SpringUtils{
	@Test
	public void testSessionFactory(){
		SessionFactory sessionFactory =  (SessionFactory) applicationContext.getBean("sessionFactory");
//		Session session = sessionFactory.openSession();
//		Transaction transaction =  session.beginTransaction();
//		transaction.begin();
//		session.save(new Department(0, "试试", "想"));
//		transaction.commit();
//		session.close();
		
	}
	
}
