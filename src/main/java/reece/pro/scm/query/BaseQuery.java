package reece.pro.scm.query;

import java.util.HashMap;
import java.util.Map;

/**
 * @filename BaseQuery.java
 * @author Reece
 * @description  提供抽象方法buildWhere让子类实现，把具体的页面上的表单元素封装到map
 * @date 2016-3-26下午3:46:30
 * @version 1.0
 */
public abstract class BaseQuery {
	/**
	 * 把表单页面的查询条件封装到map了
	 */
	private Map<String, Object> queryMap = new HashMap<String,Object>(); 
	private int currentPage = 1;
	private int pageSize = 4;
	
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}




	

	public Map<String, Object> getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(Map<String, Object> queryMap) {
		this.queryMap = queryMap;
	}




	/**
	 * 
	 * @author Reece
	 * @description 把页面上的查询条件封装为一个map并且返回。
	 * @date 2016-3-26下午3:47:59
	 * @return 封装好的Map对象
	 * 
	 */
	public abstract Map<String, Object> buildWhere();
}
