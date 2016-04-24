package reece.pro.scm.base.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.base.service.BaseService;
import reece.pro.scm.domain.privilege.Role;
import reece.pro.scm.query.BaseQuery;
import reece.pro.scm.query.PageResult;

/**
 * @filename BaseServiceImpl.java
 * @author Reece
 * @description  
 * @date 2016-3-27下午3:05:41
 * @version 
 */

public abstract class BaseServiceImpl<T> implements BaseService<T>{

	public abstract BaseDao<T> getBaseDao();
	
	@Override
	public PageResult<T> getPageResult(BaseQuery baseQuery) {
		return this.getBaseDao().findPageResult(baseQuery);
	}

	@Override
	@Transactional
	public void updateEntry(T t) {
		this.getBaseDao().updateEntry(t);
	}

	@Override
	@Transactional
	public void saveEnrty(T t) {
		this.getBaseDao().saveEntry(t);
	}

	@Override
	@Transactional
	public void deleteEntriesByIds(Serializable[] ids) {
		this.getBaseDao().deleteEntriesByIDs(ids);
	}

	@Override
	@Transactional
	public void deleteEntryById(Serializable id) {
		this.getBaseDao().deleteEntry(id);
	}

	@Override
	public T getEntryById(Serializable id) {
		return this.getBaseDao().getEntryById(id);
	}
	public Collection<T> getEntries() {
		return this.getBaseDao().findEntry();
	}
	
	@Override
	public Set<T> getEntriesByIds(Serializable[] ids) {
		return this.getBaseDao().getEntriesByIds(ids);
	}
}
