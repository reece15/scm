package reece.pro.scm.business.xsgl.dao;

import java.util.List;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;
import reece.pro.scm.domain.business.xsgl.Xsddzhub;

/**
 * @filename XsddzhubDao.java
 * @author Reece
 * @description  
 * @version 
 */
public interface XsddzhubDao extends BaseDao<Xsddzhub> {
	public List<Xsddzhib> getXsddzhibByDDH(String ddh);
	public Xsddzhub getXsddzhubByDDH(String ddh);
}
