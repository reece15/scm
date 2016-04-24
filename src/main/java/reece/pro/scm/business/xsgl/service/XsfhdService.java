package reece.pro.scm.business.xsgl.service;

import java.util.List;

import reece.pro.scm.business.base.service.BaseBusinessService;
import reece.pro.scm.domain.business.xsgl.Xsfhdzhib;
import reece.pro.scm.domain.business.xsgl.Xsfhdzhub;

/**
 * @filename XsfhdService.java
 * @author Reece
 * @description  
 * @version 
 */
public interface XsfhdService extends BaseBusinessService<Xsfhdzhub, Xsfhdzhib> {
	public void saveXsfhd(Xsfhdzhub xsfhdzhub, List<Xsfhdzhib> xsfhdzhibs);
}
