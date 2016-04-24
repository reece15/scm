package reece.pro.scm.query;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Reece
 * @description 分页类
 * @date 2016-3-26下午3:24:19
 * @param <T> 
 */
public class PageResult<T> {
	/**
	 * 主表当前页码
	 */
	private int currentPage;
	/**
	 * 字表的当前页码
	 */
	private int currrentPageSon;
	/**
	 * 一页显示的条数
	 */
	private int pageSize;
	/**
	 * 总条数
	 */
	private int totalRows;
	/**
	 * 总页数
	 */
	private int totalPages;
	/**
	 * 当前页的数据
	 */
	private List<T> rows = new ArrayList<T>();
	
	/**
	 * 
	 * @author Reece
	 * @description 分页
	 * @date 2016-3-26下午3:21:27
	 * @param currentPage 当前页码
	 * @param pageSize 页大小
	 * @param totalRows 总条数
	 */
	public PageResult(int currentPage, int pageSize, int totalRows) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRows = totalRows;
		
		//当前页码不能小于1
		this.currentPage = Math.max(this.currentPage, 1);
		//页大小不能小于1
		this.pageSize = Math.max(this.pageSize, 1);
		//计算总页数
		this.totalPages = (this.totalRows + this.pageSize - 1)/this.pageSize;
		//当前页码不能大于总页数
		this.currentPage = Math.min(this.currentPage, this.totalPages);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrrentPageSon() {
		return currrentPageSon;
	}

	public void setCurrrentPageSon(int currrentPageSon) {
		this.currrentPageSon = currrentPageSon;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageResult [currentPage=" + currentPage + ", currrentPageSon="
				+ currrentPageSon + ", pageSize=" + pageSize + ", totalRows="
				+ totalRows + ", totalPages=" + totalPages + ", rows=" + rows
				+ "]";
	}
	
}
