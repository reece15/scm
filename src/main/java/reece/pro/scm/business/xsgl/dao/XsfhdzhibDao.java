package reece.pro.scm.business.xsgl.dao;

import java.util.List;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.domain.business.xsgl.Xsfhdzhib;

/**
 * @filename XsfhdzhibDao.java
 * @author Reece
 * @description  
 * @version 
 */
public interface XsfhdzhibDao extends BaseDao<Xsfhdzhib> {
	public List<Xsfhdzhib> getXsfhdzhibByYtddh(String ytddh, Long ythh);
}
