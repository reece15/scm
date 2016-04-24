package reece.pro.scm.business.xsgl.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import reece.pro.scm.base.dao.impl.BaseDaoImpl;
import reece.pro.scm.business.xsgl.dao.XsddzhibDao;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;

/**
 * @filename XsddzhibDaoImpl.java
 * @author Reece
 * @description  
 * @version 
 */
@Repository("xsddzhibDao")
public class XsddzhibDaoImpl extends BaseDaoImpl<Xsddzhib> implements XsddzhibDao {

	@Override
	public Xsddzhib getXsddzhibByYtddh(String ytddh, Long hh) {
		List<Xsddzhib> xsddzhibs = this.hibernateTemplate.find("from Xsddzhib where xsddzhub.ddh=? and hh=?", ytddh, hh);
		String[] strings = new String[]{};
		if(xsddzhibs.size() > 0){
			return xsddzhibs.get(0);
		}else {
			return null;
		}
	}

}
