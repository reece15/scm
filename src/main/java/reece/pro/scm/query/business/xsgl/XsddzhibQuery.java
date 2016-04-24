package reece.pro.scm.query.business.xsgl;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import reece.pro.scm.query.BaseQuery;

/**
 * @filename XsddzhibQuery.java
 * @author Reece
 * @description  
 * @version 
 */
public class XsddzhibQuery extends BaseQuery {

	private Long xsddzhubid;// 销售订单主表ID
	
	private String hstatus;//行状态    "1"表示关闭   "2"表示未关闭
	

	public String getHstatus() {
		return hstatus;
	}
	public void setHstatus(String hstatus) {
		this.hstatus = hstatus;
	}
	public Long getXsddzhubid() {
		return xsddzhubid;
	}
	public void setXsddzhubid(Long xsddzhubid) {
		this.xsddzhubid = xsddzhubid;
	}
	@Override
	public Map<String, Object> buildWhere() {
		if (xsddzhubid != null) {
			this.getQueryMap().put("xsddzhub.xsddzhubid", this.xsddzhubid);
		}
		if(hstatus != null){
			this.getQueryMap().put("hstatus",this.hstatus);
		}
		return this.getQueryMap();
	}

}
