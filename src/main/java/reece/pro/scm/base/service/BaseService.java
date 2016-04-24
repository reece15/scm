package reece.pro.scm.base.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import reece.pro.scm.query.BaseQuery;
import reece.pro.scm.query.PageResult;

/**
 * @filename BaseService.java
 * @author Reece
 * @description  service接口类
 * @date 2016-3-27下午3:00:03
 * @version 1.0
 */
public interface BaseService <T>{
	public PageResult<T> getPageResult(final BaseQuery baseQuery);
	public void updateEntry(T t);
	public void saveEnrty(T t);
	public Set<T> getEntriesByIds(Serializable[] ids);
	public void deleteEntriesByIds(Serializable ids[]);
	public void deleteEntryById(Serializable id);
	public T getEntryById(Serializable id);
	public Collection<T> getEntries();
}
