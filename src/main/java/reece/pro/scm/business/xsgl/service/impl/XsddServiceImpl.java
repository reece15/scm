package reece.pro.scm.business.xsgl.service.impl;

import java.beans.PropertyDescriptor;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.business.base.service.impl.BaseBusinessServiceImpl;
import reece.pro.scm.business.xsgl.dao.XsddzhibDao;
import reece.pro.scm.business.xsgl.dao.XsddzhubDao;
import reece.pro.scm.business.xsgl.service.XsddService;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;
import reece.pro.scm.domain.business.xsgl.Xsddzhub;
import reece.pro.scm.util.GlobalKey;

/**
 * @filename XsddServiceImpl.java
 * @author Reece
 * @description  
 * @version 
 */
@Service("xsddService")
public class XsddServiceImpl extends BaseBusinessServiceImpl<Xsddzhub, Xsddzhib> implements
		XsddService {

	@Resource(name="xsddzhubDao")
	private XsddzhubDao xsddzhubDao;
	@Resource(name="xsddzhibDao")
	private XsddzhibDao xsddzhibDao;
	
	@Override
	public BaseDao<Xsddzhub> getBaseDaoZhu() {
		return xsddzhubDao;
	}

	@Override
	public BaseDao<Xsddzhib> getBaseDaoZhi() {
		return xsddzhibDao;
	}

	@Override
	public Object getXsddByDDH(String DDH) {
		Xsddzhub xsddzhub = this.xsddzhubDao.getXsddzhubByDDH(DDH);
		String status = xsddzhub.getState();
		
		if(GlobalKey.XSDDZHIB_HH_CLOSE.equals(status)){
			return "1";
		}else {
			return xsddzhub;
		}
	}

	@Override
	@Transactional
	public void updateXsdd(String item, String textValue, String ddh, Long hh)
			throws Exception {
		String type = item.split("_")[1];
		String filedKey = item.split("_")[0];//filedKey的值"spmc"
		if("zhu".equals(type)){//要修改的是主表
			Xsddzhub xsddzhub = this.xsddzhubDao.getXsddzhubByDDH(ddh);
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(filedKey, xsddzhub.getClass());
			propertyDescriptor.getWriteMethod().invoke(xsddzhub, textValue);
		}else if("zhi".equals(type)){//要修改的是子表
			Xsddzhib xsddzhib = this.xsddzhibDao.getXsddzhibByYtddh(ddh, hh);
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(filedKey, xsddzhib.getClass());
			propertyDescriptor.getWriteMethod().invoke(xsddzhib, textValue);
		}
	}

}
