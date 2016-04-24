package reece.pro.scm.business;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import reece.pro.scm.business.xsgl.dao.XsyddzhubDao;
import reece.pro.scm.business.xsgl.service.XsyddService;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;
import reece.pro.scm.domain.business.xsgl.Xsyddzhib;
import reece.pro.scm.domain.business.xsgl.Xsyddzhub;
import reece.pro.scm.query.PageResult;
import reece.pro.scm.query.business.xsgl.XsyddzhibQuery;
import reece.pro.scm.test.util.SpringUtils;


public class XsyddTest extends SpringUtils{
	@Test
	public void testQuery(){
		XsyddService xsyddService = (XsyddService)applicationContext.getBean("xsyddService");
//		XsyddzhubQuery baseQuery = new XsyddzhubQuery();
//		baseQuery.setKhmc("asdf");
//		//baseQuery.setCurrentPage(2);
//		PageResult<Xsyddzhub> pageResult_zhu = xsyddService.getEntrties_zhu(baseQuery);
//		System.out.println(pageResult_zhu.getRows().size());
		
		XsyddzhibQuery xsyddzhibQuery = new XsyddzhibQuery();
		//xsyddzhibQuery.setXsyddzhubid(1L);
		xsyddzhibQuery.setCurrentPage(3);
		//PageResult<Xsyddzhib> pageResult = xsyddService.getEntrties_zi(xsyddzhibQuery);
		//System.out.println(pageResult.getRows().size());
	}
	
	@Test
	public void testMax(){
		XsyddzhubDao xsyddzhubDao = (XsyddzhubDao)applicationContext.getBean("xsyddzhubDao");
		System.out.println(xsyddzhubDao.getMax());
	}
	
	
	public void testSaveDao(){
		XsyddzhubDao xsyddzhubDao = (XsyddzhubDao)applicationContext.getBean("xsyddzhubDao");
		Xsyddzhub xsyddzhub = new Xsyddzhub();
		xsyddzhub.setDdh(xsyddzhubDao.getMax());
		List<Xsyddzhib> xsyddzhibs = new ArrayList<Xsyddzhib>();
		Xsyddzhib xsyddzhib = new Xsyddzhib();
		xsyddzhibs.add(xsyddzhib);
		xsyddzhub.setXsyddzhibs(new HashSet<Xsyddzhib>(xsyddzhibs));
		xsyddzhubDao.saveEntry(xsyddzhub);
	}
	
	public void testSaveService(){
		XsyddService xsyddService = (XsyddService)applicationContext.getBean("xsyddService");
		Xsyddzhub xsyddzhub = new Xsyddzhub();
		xsyddzhub.setDdh(xsyddService.getMax());
		List<Xsyddzhib> xsyddzhibs = new ArrayList<Xsyddzhib>();
		Xsyddzhib xsyddzhib = new Xsyddzhib();
		xsyddzhibs.add(xsyddzhib);
		xsyddzhub.setXsyddzhibs(new HashSet<Xsyddzhib>(xsyddzhibs));
		xsyddService.saveEntry_zhu(xsyddzhub);
	}
}
