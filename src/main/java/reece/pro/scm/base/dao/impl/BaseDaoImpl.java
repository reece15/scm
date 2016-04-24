package reece.pro.scm.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import reece.pro.scm.base.dao.BaseDao;
import reece.pro.scm.query.BaseQuery;
import reece.pro.scm.query.PageResult;
import reece.pro.scm.util.ScmUtil;

/**
 * @filename BaseDaoImpl.java
 * @author Reece
 * @description  基础数据访问对象 实现了接口BaseDao
 * @date 2016-3-26下午4:17:09
 * @version 1.0
 */
public class BaseDaoImpl<T> implements BaseDao <T> {
	/**
	 * 泛型类
	 */
	private Class clazz;
	/**
	 * Hibernate的元数据 描述持久化类的属性
	 */
	private ClassMetadata classMetadata;

	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	public BaseDaoImpl() {
		
		
		//this代表子类
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) type.getActualTypeArguments()[0];
	}
	
	/**
	 * 初始化方法
	 * @author Reece
	 * @description 初始化方法 hibernate注入后执行
	 * @date 2016-3-27下午12:22:45
	 */
	@PostConstruct
	public void init(){
		this.classMetadata = this.hibernateTemplate.getSessionFactory()
				.getClassMetadata(this.clazz);
	}
	
	@Override
	public PageResult<T> findPageResult(final BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new HibernateCallback<PageResult<T>>() {

			@Override
			public PageResult<T> doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append(" from "+clazz.getSimpleName());
				stringBuffer.append(" where 1=1");
				//封装查询条件
				Map<String, Object> queryMap = baseQuery.buildWhere();
				for (Entry<String, Object>  query : queryMap.entrySet()) {
					if(query.getKey().contains(".")){
						stringBuffer.append(" and " + query.getKey() + "=:" + query.getKey().split("\\.")[1]);
					}else{
						stringBuffer.append(" and " + query.getKey() + "=:" + query.getKey());
					}
					
				}
				Query querys = session.createQuery(stringBuffer.toString());
				//给HQL语句的参数赋值
				for (Entry<String, Object> entry : queryMap.entrySet()) {
					if(entry.getKey().contains(".")){
						querys.setParameter(entry.getKey().split("\\.")[1], entry.getValue());
					}else {
						querys.setParameter(entry.getKey(), entry.getValue());
					}
				}
				//起始第N条数据
				int firstResult = (baseQuery.getCurrentPage() - 1) * baseQuery.getPageSize();
				//最多取几条数据
				int maxResults = baseQuery.getPageSize();
				//设置查询语句
				querys.setFirstResult(firstResult).setMaxResults(maxResults);
				//得到结果
				List<T> list = querys.list();

				//分页数据
				PageResult<T> pageResult = new PageResult<T>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), getCount(baseQuery));
				pageResult.setRows(list);
				
				return pageResult;
			}
		});
	}

	@Override
	public Collection<T> findEntry() {
		return this.hibernateTemplate.find(" from " + this.clazz.getSimpleName());
	}

	@Override
	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	@Override
	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}

	@Override
	public void deleteEntriesByIDs(Serializable[] ids) {
		//hql语句
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(" from " + this.clazz.getSimpleName());
		stringBuffer.append(" where " + this.classMetadata.getIdentifierPropertyName());
		//查询条件
		StringBuffer tempBuffer = new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			if(i == ids.length - 1){
				tempBuffer.append(ids[i]);
			}else {
				tempBuffer.append(ids[i] + ",");
			}
		}
		//拼接语句
		stringBuffer.append(" in (" + tempBuffer.toString() + ")");
		//查找到的实体集
		List<T> list = this.hibernateTemplate.find(stringBuffer.toString());
		//删除
		this.hibernateTemplate.deleteAll(list);
	}

	@Override
	public void deleteEntry(Serializable id) {
		T t = (T) this.hibernateTemplate.get(clazz, id);
		this.hibernateTemplate.delete(t);
	}

	@Override
	public T getEntryById(Serializable id) {
		return  (T) this.hibernateTemplate.get(clazz, id);
	}

	@Override
	public Set<T> getEntriesByIds(Serializable[] ids) {
		//hql语句
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(" from " + this.clazz.getSimpleName());
		stringBuffer.append(" where " + this.classMetadata.getIdentifierPropertyName());
		//查询条件
		StringBuffer tempBuffer = new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			if(i == ids.length - 1){
				tempBuffer.append(ids[i]);
			}else {
				tempBuffer.append(ids[i] + ",");
			}
		}
		//拼接语句
		stringBuffer.append(" in (" + tempBuffer.toString() + ")");
		//查找到的实体集
		List<T> list = this.hibernateTemplate.find(stringBuffer.toString());		
		return new HashSet<T>(list);
	}

	@Override
	public int getCount(final BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer stringBuffer = new StringBuffer();
				
				stringBuffer.append("select count(" + classMetadata.getIdentifierPropertyName() + ") from "+clazz.getSimpleName());
				stringBuffer.append(" where 1=1 ");
				//获取所有的查询条件
				Map<String, Object> queryMap = baseQuery.buildWhere();
				
				//拼接where查询条件
				for (Entry<String, Object> entry : queryMap.entrySet()) {
					if(entry.getKey().contains(".")){
						stringBuffer.append(" and " + entry.getKey() + "=:" + entry.getKey().split("\\.")[1]);
					}else{
						stringBuffer.append(" and " + entry.getKey() + "=:" + entry.getKey());
					}
				}
				Query query = session.createQuery(stringBuffer.toString());
				
				//给where条件中的参数传递值
				for (Entry<String, Object> entry : queryMap.entrySet()) {
					if(entry.getKey().contains(".")){
						query.setParameter(entry.getKey().split("\\.")[1], entry.getValue());
					}else {
						query.setParameter(entry.getKey(), entry.getValue());
					}
				}
				Long count = (Long)query.uniqueResult();
				return count.intValue();
			}
		});
	}
	/**
	 * 计算某一个订单号的最大值
	 */
	public String getMax(){
		List list = this.hibernateTemplate.
				find("select max(ddh) from " + this.clazz.getSimpleName() + " where ddh like '%" + ScmUtil.getDateToString() + "%'");
		if(list.get(0) == null){
			return ScmUtil.getDateToString()+"0001";
		}else{
			String temp = (String)list.get(0);
			return ""+(Long.parseLong(temp) + 1);
		}
	}

}
