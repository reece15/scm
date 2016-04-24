package reece.pro.scm.business;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import reece.pro.scm.business.xsgl.dao.XsddzhibDao;
import reece.pro.scm.business.xsgl.service.XskpService;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;
import reece.pro.scm.domain.business.xsgl.Xskpzhib;
import reece.pro.scm.domain.business.xsgl.Xskpzhub;
import reece.pro.scm.test.util.SpringUtils;


public class XskpTest extends SpringUtils{
	@Test
	public void testSaveXskp(){
		XskpService xskpService = (XskpService)applicationContext.getBean("xskpService");
		Xskpzhub xskpzhub = new Xskpzhub();
		List<Xskpzhib> xskpzhibs = new ArrayList<Xskpzhib>();
		Xskpzhib xskpzhib = new Xskpzhib();
		xskpzhib.setSl(10L);//设置实发数量
		xskpzhib.setYtdjh("201410240001");//源头单据号
		xskpzhib.setYthh(1L);//源头行号
		xskpzhib.setHsje(2000F);//设置含税金额
		xskpzhibs.add(xskpzhib);
		xskpService.saveXskp(xskpzhub, xskpzhibs);
		
		System.out.println("销售开票单子表是否结束："+xskpzhib.getIskpjs());
		XsddzhibDao xsddzhibDao = (XsddzhibDao)applicationContext.getBean("xsddzhibDao");
		Xsddzhib xsddzhib = xsddzhibDao.getXsddzhibByYtddh("201410240001", 1L);
		System.out.println("销售开票子表累计开票数量:"+xsddzhib.getLjkpsl());
		System.out.println("是否开票结束:"+xsddzhib.getIskpgb());
		System.out.println("开票的总的金额数:"+xskpzhub.getFpzje());
	}
	
	@Test
	public void testQuery(){
		XsddzhibDao xsddzhibDao = (XsddzhibDao)applicationContext.getBean("xsddzhibDao");
		Xsddzhib xsddzhib = xsddzhibDao.getXsddzhibByYtddh("201410240001", 1L);
		System.out.println(xsddzhib.getIsckgb());
	}
	
	@Test
	public void testSetIskpgb(){
		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Xsddzhib xsddzhib = (Xsddzhib)session.get(Xsddzhib.class, 1L);
		xsddzhib.setIskpgb(false);
		transaction.commit();
		session.close();
	}
}
