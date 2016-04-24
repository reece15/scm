package reece.pro.scm.business.xsgl.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import reece.pro.scm.base.dao.impl.BaseDaoImpl;
import reece.pro.scm.business.xsgl.dao.XsddzhubDao;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;
import reece.pro.scm.domain.business.xsgl.Xsddzhub;

/**
 * @filename XsddzhubDaoImpl.java
 * @author Reece
 * @description  
 * @version 
 */
@Repository("xsddzhubDao")
public class XsddzhubDaoImpl extends BaseDaoImpl<Xsddzhub> implements XsddzhubDao {

	@Override
	public List<Xsddzhib> getXsddzhibByDDH(String ddh) {
		return this.hibernateTemplate.find("from Xsddzhib where xsddzhub.ddh=?", ddh);
	}

	@Override
	public Xsddzhub getXsddzhubByDDH(String ddh) {
		return (Xsddzhub) this.hibernateTemplate.find("from Xsddzhub where ddh=?", ddh).get(0);
	}

}
