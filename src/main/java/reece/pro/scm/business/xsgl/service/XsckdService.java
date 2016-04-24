package reece.pro.scm.business.xsgl.service;

import java.util.List;

import reece.pro.scm.business.base.service.BaseBusinessService;
import reece.pro.scm.domain.business.xsgl.Xsckdzhib;
import reece.pro.scm.domain.business.xsgl.Xsckdzhub;

/**
 * @filename XsckdService.java
 * @author Reece
 * @description  
 * @version 
 */
public interface XsckdService extends BaseBusinessService<Xsckdzhub, Xsckdzhib> {
	public void saveXsckd(Xsckdzhub xsckdzhub, List<Xsckdzhib> xsckdzhibs);
}
