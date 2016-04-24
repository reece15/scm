package reece.pro.scm.business.xsgl.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.business.base.service.impl.BaseBusinessServiceImpl;
import reece.pro.scm.business.xsgl.dao.XsddzhibDao;
import reece.pro.scm.business.xsgl.dao.XskpzhibDao;
import reece.pro.scm.business.xsgl.dao.XskpzhubDao;
import reece.pro.scm.business.xsgl.service.XskpService;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;
import reece.pro.scm.domain.business.xsgl.Xskpzhib;
import reece.pro.scm.domain.business.xsgl.Xskpzhub;
import reece.pro.scm.query.BaseQuery;
import reece.pro.scm.query.PageResult;

/**
 * @filename xskpzhubServiceImpl.java
 * @author Reece
 * @description  
 * @version 
 */
@Service("xskpService")
public class XskpServiceImpl extends BaseBusinessServiceImpl<Xskpzhub, Xskpzhib>
		implements XskpService {
	
	@Resource(name="xskpzhubDao")
	private XskpzhubDao xskpzhubDao;
	@Resource(name="xskpzhibDao")
	private XskpzhibDao xskpzhibDao;
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	@Override
	public BaseDao<Xskpzhub> getBaseDaoZhu() {
		return xskpzhubDao;
	}

	@Override
	public BaseDao<Xskpzhib> getBaseDaoZhi() {
		return xskpzhibDao;
	}

	@Override
	public void saveXskp(Xskpzhub xskpzhub, List<Xskpzhib> xskpzhibs) {
		Float totalMoney = 0.0F;
		for (Xskpzhib xskpzhib : xskpzhibs) {
			String ytdjh = xskpzhib.getYtdjh();
			Long hh = xskpzhib.getHh();
			
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhibByYtddh(ytdjh, hh);
			Long ljkpsj = xsddzhib.getLjkpsl();
			xskpzhib.setLjkpsl(ljkpsj + xskpzhib.getSl());
			xsddzhib.setLjkpsl(ljkpsj + xskpzhib.getSl());
			
			if(xsddzhib.getLjkpsl().longValue() == xskpzhib.getLjkpsl().longValue()){
				xsddzhib.setIskpgb(true);
				xskpzhib.setIskpjs(true);
			}
			totalMoney += xskpzhib.getHsje();
		}
		xskpzhub.setFpzje(totalMoney);
		xskpzhub.setXskpzhibs(new HashSet<Xskpzhib>(xskpzhibs));
		this.xskpzhubDao.saveEntry(xskpzhub);
	}

	

}
