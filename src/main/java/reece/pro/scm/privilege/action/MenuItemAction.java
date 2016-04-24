package reece.pro.scm.privilege.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import reece.pro.scm.base.action.BaseAction;
import reece.pro.scm.domain.privilege.Menuitem;
import reece.pro.scm.privilege.annotation.PrivilegeInfo;
import reece.pro.scm.privilege.service.MenuitemService;
import reece.pro.scm.privilege.service.RoleService;
import reece.pro.scm.query.basedata.UserQuery;

/**
 * @filename MenuItemAction.java
 * @author Reece
 * @description  
 * @date 2016-3-29下午7:17:23
 * @version 
 */
@Controller("menuitemAction")
@Scope("prototype")
public class MenuItemAction extends BaseAction<Menuitem> {
	@Resource(name="menuitemService")
	private MenuitemService menuitemService;
	private UserQuery baseQuery = new UserQuery();
	
	
	public String showMenuitemTree(){
		Collection<Menuitem> menuitems = this.menuitemService.getEntries();
		for (Menuitem menuitem : menuitems) {
			System.err.println(menuitem);
		}
		
		ActionContext.getContext().getValueStack().push(menuitems);
		return SUCCESS;
	}
}
