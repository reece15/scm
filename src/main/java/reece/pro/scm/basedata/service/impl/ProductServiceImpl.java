package reece.pro.scm.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import reece.pro.scm.base.dao.BaseDao;

import reece.pro.scm.base.service.impl.BaseServiceImpl;
import reece.pro.scm.basedata.dao.ProductDao;
import reece.pro.scm.basedata.service.ProductService;
import reece.pro.scm.domain.basedata.Product;

/**
 * @filename ProductServiceImpl.java
 * @author Reece
 * @description  
 * @version 
 */
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
	
	@Resource(name="productDao")
	private ProductDao productDao;
	
	@Override
	public BaseDao<Product> getBaseDao() {
		return this.productDao;
	}

}
