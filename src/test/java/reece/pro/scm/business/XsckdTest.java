package reece.pro.scm.business;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import reece.pro.scm.business.xsgl.dao.XsddzhibDao;
import reece.pro.scm.business.xsgl.service.XsckdService;
import reece.pro.scm.domain.business.xsgl.Xsckdzhib;
import reece.pro.scm.domain.business.xsgl.Xsckdzhub;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;
import reece.pro.scm.test.util.SpringUtils;



public class XsckdTest extends SpringUtils{
	@Test
	public void testSaveXsckd(){
		XsckdService xsckdService = (XsckdService)applicationContext.getBean("xsckdService");
		Xsckdzhub xsckdzhub = new Xsckdzhub();
		List<Xsckdzhib> xsckdzhibs = new ArrayList<Xsckdzhib>();
		Xsckdzhib xsckdzhib = new Xsckdzhib();
		xsckdzhib.setSfsl(10L);//设置实发数量
		xsckdzhib.setYtdjh("201410240001");//源头单据号
		xsckdzhib.setYthh(1L);//源头行号
		xsckdzhibs.add(xsckdzhib);
		xsckdService.saveXsckd(xsckdzhub, xsckdzhibs);
		
		System.out.println("销售出库单子表是否关闭："+xsckdzhib.getIsckgb());
		XsddzhibDao xsddzhibDao = (XsddzhibDao)applicationContext.getBean("xsddzhibDao");
		Xsddzhib xsddzhib = xsddzhibDao.getXsddzhibByYtddh("201410240001", 1L);
		System.out.println("销售订单子表累计发货数量:"+xsddzhib.getLjcksl());
		System.out.println("是否出库关闭:"+xsddzhib.getIsckgb());
	}
	
	@Test
	public void testQuery(){
		XsddzhibDao xsddzhibDao = (XsddzhibDao)applicationContext.getBean("xsddzhibDao");
		Xsddzhib xsddzhib = xsddzhibDao.getXsddzhibByYtddh("201410240001", 1L);
		System.out.println(xsddzhib.getIsckgb());
	}
	
	@Test
	public void testSetIsckgb(){
		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Xsddzhib xsddzhib = (Xsddzhib)session.get(Xsddzhib.class, 1L);
		xsddzhib.setIsckgb(false);
		transaction.commit();
		session.close();
	}
}
