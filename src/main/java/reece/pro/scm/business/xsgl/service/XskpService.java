package reece.pro.scm.business.xsgl.service;

import java.util.List;

import reece.pro.scm.business.base.service.BaseBusinessService;
import reece.pro.scm.domain.business.xsgl.Xskpzhib;
import reece.pro.scm.domain.business.xsgl.Xskpzhub;

/**
 * @filename XskpService.java
 * @author Reece
 * @description  
 * @version 
 */
public interface XskpService extends BaseBusinessService<Xskpzhub, Xskpzhib> {
	public void saveXskp(Xskpzhub xskpzhub, List<Xskpzhib> xskpzhibs);
}
