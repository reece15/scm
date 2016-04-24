package reece.pro.scm.business.xsgl.service;

import reece.pro.scm.business.base.service.BaseBusinessService;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;
import reece.pro.scm.domain.business.xsgl.Xsddzhub;

/**
 * @filename XsddService.java
 * @author Reece
 * @description  
 * @version 
 */
public interface XsddService extends BaseBusinessService<Xsddzhub, Xsddzhib>{
	public Object getXsddByDDH(String DDH);
	
	public void updateXsdd(String item, String textValue, String ddh,Long hh) throws Exception;
}
