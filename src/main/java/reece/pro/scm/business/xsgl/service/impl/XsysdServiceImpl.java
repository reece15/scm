package reece.pro.scm.business.xsgl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.business.base.service.impl.BaseBusinessServiceImpl;
import reece.pro.scm.business.xsgl.dao.XsysdzhibDao;
import reece.pro.scm.business.xsgl.dao.XsysdzhubDao;
import reece.pro.scm.business.xsgl.service.XsysdService;
import reece.pro.scm.domain.business.xsgl.Xsysdzhib;
import reece.pro.scm.domain.business.xsgl.Xsysdzhub;
import reece.pro.scm.query.BaseQuery;
import reece.pro.scm.query.PageResult;

/**
 * @filename XsysdServiceImpl.java
 * @author Reece
 * @description  
 * @version 
 */
@Service("xsysdService")
public class XsysdServiceImpl extends BaseBusinessServiceImpl<Xsysdzhub, Xsysdzhib> implements
		XsysdService {

	@Resource(name="xsysdzhubDao")
	private XsysdzhubDao xsysdzhubDao;
	@Resource(name="xsysdzhibDao")
	private XsysdzhibDao xsysdzhibDao;
	
	
	@Override
	public BaseDao<Xsysdzhub> getBaseDaoZhu() {
		return xsysdzhubDao;
	}

	@Override
	public BaseDao<Xsysdzhib> getBaseDaoZhi() {
		return xsysdzhibDao;
	}

	@Override
	public void saveXsysd(Xsysdzhub xsysdzhub, List<Xsysdzhib> xsysdzhibs) {
		// TODO Auto-generated method stub
		
	}

	

	

}
