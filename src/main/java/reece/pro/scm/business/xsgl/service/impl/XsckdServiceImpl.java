package reece.pro.scm.business.xsgl.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.business.base.service.impl.BaseBusinessServiceImpl;
import reece.pro.scm.business.xsgl.dao.XsckdzhibDao;
import reece.pro.scm.business.xsgl.dao.XsckdzhubDao;
import reece.pro.scm.business.xsgl.dao.XsddzhibDao;
import reece.pro.scm.business.xsgl.service.XsckdService;
import reece.pro.scm.domain.business.xsgl.Xsckdzhib;
import reece.pro.scm.domain.business.xsgl.Xsckdzhub;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;

/**
 * @filename XsckdServiceImpl.java
 * @author Reece
 * @description  
 * @version 
 */
@Service("xsckdService")
public class XsckdServiceImpl extends BaseBusinessServiceImpl<Xsckdzhub, Xsckdzhib> implements
		XsckdService {

	@Resource(name="xsckdzhubDao")
	private XsckdzhubDao xsckdzhubDao;
	@Resource(name="xsckdzhibDao")
	private XsckdzhibDao xsckdzhibDao;
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	@Override
	public BaseDao<Xsckdzhub> getBaseDaoZhu() {
		return xsckdzhubDao;
	}

	@Override
	public BaseDao<Xsckdzhib> getBaseDaoZhi() {
		return xsckdzhibDao;
	}

	@Override
	@Transactional
	public void saveXsckd(Xsckdzhub xsckdzhub, List<Xsckdzhib> xsckdzhibs) {
		for (Xsckdzhib xsckdzhib : xsckdzhibs) {
			String ytdjh = xsckdzhib.getYtdjh();
			Long hh = xsckdzhib.getHh();
			
			//得到总出库量
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhibByYtddh(ytdjh, hh);
			Long ljcksl = xsddzhib.getLjcksl();
			//更新总出库量
			xsddzhib.setLjcksl(ljcksl + xsckdzhib.getSfsl());
			xsckdzhib.setLjcksl(ljcksl + xsckdzhib.getSfsl());
			if(xsddzhib.getLjcksl().longValue() == xsddzhib.getSl().longValue()){
				xsddzhib.setIsckgb(true);
				xsckdzhib.setIsckgb(true);
			}
		}
		xsckdzhub.setXsckdzhibs(new HashSet<Xsckdzhib>(xsckdzhibs));
		this.xsckdzhubDao.saveEntry(xsckdzhub);
	}

}
