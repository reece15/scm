package reece.pro.scm.business;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import reece.pro.scm.business.xsgl.dao.XsddzhibDao;
import reece.pro.scm.business.xsgl.service.XsfhdService;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;
import reece.pro.scm.domain.business.xsgl.Xsfhdzhib;
import reece.pro.scm.domain.business.xsgl.Xsfhdzhub;
import reece.pro.scm.test.util.SpringUtils;



public class XsfhdTest extends SpringUtils{
	@Test
	public void testSaveXsfhd(){
		XsfhdService xsfhdService = (XsfhdService)applicationContext.getBean("xsfhdService");
		Xsfhdzhub xsfhdzhub = new Xsfhdzhub();
		List<Xsfhdzhib> xsfhdzhibs = new ArrayList<Xsfhdzhib>();
		Xsfhdzhib xsfhdzhib = new Xsfhdzhib();
		xsfhdzhib.setSfsl(10L);//设置实发数量
		xsfhdzhib.setYtdjh("201410240001");//源头单据号
		xsfhdzhib.setYthh(1L);//源头行号
		xsfhdzhibs.add(xsfhdzhib);
		xsfhdService.saveXsfhd(xsfhdzhub, xsfhdzhibs);
		
		System.out.println("销售发货单子表是否关闭："+xsfhdzhib.getIsfhgb());
		XsddzhibDao xsddzhibDao = (XsddzhibDao)applicationContext.getBean("xsddzhibDao");
		Xsddzhib xsddzhib = xsddzhibDao.getXsddzhibByYtddh("201410240001", 1L);
		System.out.println("销售订单子表累计发货数量:"+xsddzhib.getLjfhsl());
		System.out.println("是否发货关闭:"+xsddzhib.getIsfhgb());
	}
	
	@Test
	public void testQuery(){
		XsddzhibDao xsddzhibDao = (XsddzhibDao)applicationContext.getBean("xsddzhibDao");
		Xsddzhib xsddzhib = xsddzhibDao.getXsddzhibByYtddh("201410240001", 1L);
		System.out.println(xsddzhib.getIsfhgb());
	}
	
	@Test
	public void testSetIsfhgb(){
		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Xsddzhib xsddzhib = (Xsddzhib)session.get(Xsddzhib.class, 1L);
		xsddzhib.setIsfhgb(false);
		transaction.commit();
		session.close();
	}
}
