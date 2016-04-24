package reece.pro.scm.login.Action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import reece.pro.scm.base.action.BaseAction;
import reece.pro.scm.domain.basedata.User;
import reece.pro.scm.domain.privilege.Privilege;
import reece.pro.scm.login.service.LoginService;
import reece.pro.scm.privilege.service.PrivilegeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @filename LoginAction.java
 * @author Reece 
 * @description   用户登录请求的action
 * @version 
 */
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User>{
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	private String username;
	private String password;
	
	public String login(){
		username = this.getModel().getUsername();
		password = this.getModel().getPassword();
		User user = this.loginService.checUser(username, password);
		if(user == null){
			this.addActionError("用户名或者密码错误!");
			return "login";
		}else {
			Collection<Privilege> privileges = this.privilegeService.getFunctionTreeByUid(user.getUid());
			this.getSession().setAttribute("user",user);
			//把用户能够访问的功能权限放入seesion
			this.getSession().setAttribute("func", privileges);
			return "comein";
		}
	}

	
	
}
