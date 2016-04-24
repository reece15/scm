package reece.pro.scm.business.base.service.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.business.base.service.BaseBusinessService;
import reece.pro.scm.domain.business.xsgl.Xsyddzhub;
import reece.pro.scm.query.BaseQuery;
import reece.pro.scm.query.PageResult;

/**
 * @filename BaseBusinessServiceImpl.java
 * @author Reece
 * @description  
 * @version 
 * @param <T>
 */

public abstract class BaseBusinessServiceImpl<T extends Serializable, E extends Serializable> implements BaseBusinessService<T, E > {

	public abstract BaseDao<T> getBaseDaoZhu();
	
	public abstract BaseDao<E> getBaseDaoZhi();
	
	@Override
	public PageResult<T> findPageResultZhu(BaseQuery baseQuery) {
		return this.getBaseDaoZhu().findPageResult(baseQuery);
	}

	@Override
	public PageResult<E> findPageResultZi(BaseQuery baseQuery) {
		return this.getBaseDaoZhi().findPageResult(baseQuery);
	}
	
	@Override
	public String getMax() {
		return this.getBaseDaoZhu().getMax();
	}

	@Override
	public void saveEntry_zhu(T t) {
		this.getBaseDaoZhu().saveEntry(t);
	}

}
