package reece.pro.scm.business.xsgl.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import reece.pro.scm.base.dao.impl.BaseDaoImpl;
import reece.pro.scm.business.xsgl.dao.XsfhdzhibDao;
import reece.pro.scm.domain.business.xsgl.Xsfhdzhib;

/**
 * @filename XsfhdzhibDaoImpl.java
 * @author Reece
 * @description  
 * @version 
 */
@Repository("xsfhdzhibDao")
public class XsfhdzhibDaoImpl extends BaseDaoImpl<Xsfhdzhib> implements XsfhdzhibDao {

	@Override
	public List<Xsfhdzhib> getXsfhdzhibByYtddh(String ytddh, Long ythh) {
		return this.hibernateTemplate.find("from Xsfhdzhib where ytdjh=? and ythh=?", ytddh, ythh);
	}

}
