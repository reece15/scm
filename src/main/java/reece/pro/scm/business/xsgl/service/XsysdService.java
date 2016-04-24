package reece.pro.scm.business.xsgl.service;

import java.util.List;

import reece.pro.scm.business.base.service.BaseBusinessService;
import reece.pro.scm.domain.business.xsgl.Xsysdzhib;
import reece.pro.scm.domain.business.xsgl.Xsysdzhub;

/**
 * @filename XsysdService.java
 * @author Reece
 * @description  
 * @version 
 */
public interface XsysdService extends BaseBusinessService<Xsysdzhub, Xsysdzhib> {
	/**
	 * 保存销售预售单
	 * @author Reece
	 * @description 
	 * @param xsysdzhub
	 * @param xsysdzhibs
	 */
	public void saveXsysd(Xsysdzhub xsysdzhub, List<Xsysdzhib> xsysdzhibs);
}
