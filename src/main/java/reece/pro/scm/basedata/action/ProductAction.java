package reece.pro.scm.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import reece.pro.scm.base.action.BaseAction;
import reece.pro.scm.basedata.service.ProductService;
import reece.pro.scm.domain.basedata.Product;
import reece.pro.scm.privilege.annotation.PrivilegeInfo;

/**
 * @filename ProductAction.java
 * @author Reece
 * @description  
 * @version 
 */
@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	@Resource(name="productService")
	private ProductService productService;
	
	@PrivilegeInfo(name="商品查询")
	public String showProduct(){
		Collection<Product> products = this.productService.getEntries();
		ActionContext.getContext().getValueStack().push(products);
		return SUCCESS;
	}
	
	
}
