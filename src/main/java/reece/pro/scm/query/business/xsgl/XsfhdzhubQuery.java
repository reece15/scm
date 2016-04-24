package reece.pro.scm.query.business.xsgl;

import java.util.Date;
import java.util.Map;

import reece.pro.scm.query.BaseQuery;

/**
 * @filename XsfhdzhubQuery.java
 * @author Reece
 * @description  
 * @version 
 */
public class XsfhdzhubQuery extends BaseQuery {

	private String ddh;//单据号
	private Date djrq;//单据日期
	private String gs;//公司
	private String ck;//仓库
	private String kgy;//库管员
	private String bm;//部门
	private String kh;//客户
	private Boolean isth;//是否退货
	private String status;//单据状态
	private String zdr;//制单人
	private Date zdrq;//制单日期
	private String shr;//审核人
	private Date shrq;//审核日期
	private String qzr;//签字人
	private Date xgrq;//修改日期
	
	@Override
	public Map<String, Object> buildWhere() {
		return null;
	}

}
