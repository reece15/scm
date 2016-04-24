package reece.pro.scm.business.base.service;

import java.io.Serializable;

import reece.pro.scm.query.BaseQuery;
import reece.pro.scm.query.PageResult;

/**主要业务的逻辑
 * @filename BaseBusinessService.java
 * @author Reece
 * @description  
 * @version 
 */
public interface BaseBusinessService<T extends Serializable, E extends Serializable> {
	public PageResult<T> findPageResultZhu(BaseQuery baseQuery);
	public PageResult<E> findPageResultZi(BaseQuery baseQuery);
	
	/**
	 * 得到订单号的最大值+1
	 * @return
	 */
	public String getMax();
	
	/**
	 * 保存主表，级联保存子表
	 */
	public void saveEntry_zhu(T t);
}
