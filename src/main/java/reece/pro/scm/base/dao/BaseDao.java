package reece.pro.scm.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import reece.pro.scm.query.BaseQuery;
import reece.pro.scm.query.PageResult;

/**
 * @filename BaseDao.java
 * @author Reece
 * @description 基本Dao的抽象 curd操作  
 * @date 2016-3-26下午3:57:43
 * @version 1.0
 */
public interface BaseDao <T> {
	
	
	/**
	 * 分页查询
	 * @author Reece
	 * @description 分页查询
	 * @date 2016-3-26下午3:59:30
	 * @param baseQuery 查询条件
	 * @return 分页结果集
	 */
	public PageResult<T> findPageResult(BaseQuery baseQuery);
	/**
	 * 不分页的查询
	 * @author Reece
	 * @description 不分页的查询 
	 * @date 2016-3-26下午4:00:48
	 * @return 结果集
	 */
	public Collection<T> findEntry();
	/**
	 * 保存
	 * @author Reece
	 * @description 保存
	 * @date 2016-3-26下午4:02:01
	 * @param t 要保存的实体对象
	 */
	public void saveEntry(T t);
	/**
	 * 更新
	 * @author Reece
	 * @description 更新数据
	 * @date 2016-3-26下午4:02:31
	 * @param t 要更新的实体对象
	 */
	public void updateEntry(T t);
	/**
	 * 根据id删除多条信息
	 * @author Reece
	 * @description 根据传入的id（多个） 删除信息 
	 * @date 2016-3-26下午4:04:20
	 * @param ids 传入的id数组
	 */
	public void deleteEntriesByIDs(Serializable[] ids);
	/**
	 * 根据id删除1条信息
	 * @author Reece
	 * @description 根据传入的id（1条） 删除信息 
	 * @date 2016-3-26下午4:06:28
	 * @param id 传入的id
	 */
	public void deleteEntry(Serializable id);
	/**
	 * 根据Id来查询信息
	 * @author Reece
	 * @description 根据Id来查询信息
	 * @date 2016-3-26下午4:07:52
	 * @param id id
	 * @return  查询到的结果实体对象
	 */
	public T getEntryById(Serializable id);
	/**
	 * 根据多个id查询
	 * @author Reece
	 * @description 根据多个id查询信息
	 * @date 2016-3-26下午4:10:19
	 * @param ids id数组
	 * @return 结果集合
	 */
	public Set<T> getEntriesByIds(Serializable[] ids);
	/**
	 * 查询表内记录数
	 * @author Reece
	 * @description 查询表内记录数
	 * @date 2016-3-26下午4:25:30
	 * @return 数据条数
	 */
	public int getCount(final BaseQuery baseQuery);
	/**
	 * 计算某一个订单号的最大值
	 */
	public String getMax();
}
