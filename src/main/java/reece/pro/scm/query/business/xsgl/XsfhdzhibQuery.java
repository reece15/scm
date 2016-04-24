package reece.pro.scm.query.business.xsgl;

import java.util.Map;

import reece.pro.scm.query.BaseQuery;

/**
 * @filename XsfhdzhibQuery.java
 * @author Reece
 * @description  
 * @version 
 */
public class XsfhdzhibQuery extends BaseQuery {

	private Long xsfhdzhubid;
	
	private Boolean isfhgb;
	
	
	
	public Long getXsfhdzhubid() {
		return xsfhdzhubid;
	}



	public void setXsfhdzhubid(Long xsfhdzhubid) {
		this.xsfhdzhubid = xsfhdzhubid;
	}



	public Boolean getIsfhgb() {
		return isfhgb;
	}



	public void setIsfhgb(Boolean isfhgb) {
		this.isfhgb = isfhgb;
	}



	@Override
	public Map<String, Object> buildWhere() {
		if(isfhgb != null){
			getQueryMap().put("isfhgb", isfhgb);
		}
		if(xsfhdzhubid != null){
			getQueryMap().put("xsfhdzhubid", xsfhdzhubid);
		}
		return getQueryMap();
	}

}
