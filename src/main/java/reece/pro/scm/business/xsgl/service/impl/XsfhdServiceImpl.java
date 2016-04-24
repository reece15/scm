package reece.pro.scm.business.xsgl.service.impl;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.business.base.service.impl.BaseBusinessServiceImpl;
import reece.pro.scm.business.xsgl.dao.XsddzhibDao;
import reece.pro.scm.business.xsgl.dao.XsfhdzhibDao;
import reece.pro.scm.business.xsgl.dao.XsfhdzhubDao;
import reece.pro.scm.business.xsgl.service.XsfhdService;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;
import reece.pro.scm.domain.business.xsgl.Xsfhdzhib;
import reece.pro.scm.domain.business.xsgl.Xsfhdzhub;

/**
 * @filename XsfhdServiceImpl.java
 * @author Reece
 * @description  
 * @version 
 */
@Service("xsfhdService")
public class XsfhdServiceImpl extends BaseBusinessServiceImpl<Xsfhdzhub, Xsfhdzhib> implements
		XsfhdService {
	
	@Resource(name="xsfhdzhubDao")
	private XsfhdzhubDao xsfhdzhubDao;
	@Resource(name="xsfhdzhibDao")
	private XsfhdzhibDao xsfhdzhibDao;
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	
	@Override
	public BaseDao<Xsfhdzhub> getBaseDaoZhu() {
		return xsfhdzhubDao;
	}

	@Override
	public BaseDao<Xsfhdzhib> getBaseDaoZhi() {
		return xsfhdzhibDao;
	}

	@Override
	@Transactional
	public void saveXsfhd(Xsfhdzhub xsfhdzhub, List<Xsfhdzhib> xsfhdzhibs) {
		for (Xsfhdzhib xsfhdzhib : xsfhdzhibs) {
			String ytddh = xsfhdzhib.getYtdjh();
			Long hh = xsfhdzhib.getYthh();
			List<Xsfhdzhib> xsfhdzhibs2 = this.xsfhdzhibDao.getXsfhdzhibByYtddh(ytddh, hh);
			Long ljfhsl = 0L;
			/**
			 * 更新每样物品的累计发货量
			 */
			for (Xsfhdzhib xsfhdzhib2 : xsfhdzhibs2) {
				ljfhsl += xsfhdzhib2.getSfsl();//实发数量
			}
			xsfhdzhib.setLjfhsl(ljfhsl + xsfhdzhib.getSfsl());
			
			/**
			 * 计算是否发货结束
			 */
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhibByYtddh(ytddh, hh);
			Long sl = xsddzhib.getSl();
			if(sl.longValue() == xsfhdzhib.getLjfhsl().longValue()){
				xsfhdzhib.setIsfhgb(true);
				xsddzhib.setIsfhgb(true);
			}
		}
		//保存
		xsfhdzhub.setXsfhdzhibs(new HashSet<Xsfhdzhib>(xsfhdzhibs));
		this.xsfhdzhubDao.saveEntry(xsfhdzhub);
	}

}
