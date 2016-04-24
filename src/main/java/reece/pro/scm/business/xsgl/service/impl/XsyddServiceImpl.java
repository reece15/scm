package reece.pro.scm.business.xsgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.business.base.service.impl.BaseBusinessServiceImpl;
import reece.pro.scm.business.xsgl.dao.XsyddzhibDao;
import reece.pro.scm.business.xsgl.dao.XsyddzhubDao;
import reece.pro.scm.business.xsgl.service.XsyddService;
import reece.pro.scm.domain.business.xsgl.Xsyddzhib;
import reece.pro.scm.domain.business.xsgl.Xsyddzhub;
import reece.pro.scm.query.BaseQuery;
import reece.pro.scm.query.PageResult;

/**
 * @filename XsyddServiceImpl.java
 * @author Reece
 * @description  
 * @version 
 */

@Service("xsyddService")
public class XsyddServiceImpl extends BaseBusinessServiceImpl<Xsyddzhub, Xsyddzhib> implements XsyddService {

	@Resource(name="xsyddzhubDao")
	private XsyddzhubDao baseDaoZhu;
	
	@Resource(name="xsyddzhibDao")
	private XsyddzhibDao baseDaoZhi;
	
	@Override
	public PageResult<Xsyddzhub> findPageResultZhu(BaseQuery baseQuery) {
		return baseDaoZhu.findPageResult(baseQuery);
	}

	@Override
	public PageResult<Xsyddzhib> findPageResultZi(BaseQuery baseQuery) {
		return baseDaoZhi.findPageResult(baseQuery);
	}

	

	@Override
	public BaseDao<Xsyddzhub> getBaseDaoZhu() {
		return baseDaoZhu;
	}

	@Override
	public BaseDao<Xsyddzhib> getBaseDaoZhi() {
		return baseDaoZhi;
	}

	

}
