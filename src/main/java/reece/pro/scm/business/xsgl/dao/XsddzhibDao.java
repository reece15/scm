package reece.pro.scm.business.xsgl.dao;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;

/**
 * @filename Xsddzhib.java
 * @author Reece
 * @description  
 * @version 
 */
public interface XsddzhibDao extends BaseDao<Xsddzhib> {
	public Xsddzhib getXsddzhibByYtddh(String ytddh, Long hh);
}
