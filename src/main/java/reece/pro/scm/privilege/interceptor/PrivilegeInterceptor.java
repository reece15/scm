package reece.pro.scm.privilege.interceptor;

import java.util.Collection;

import org.apache.struts2.ServletActionContext;

import reece.pro.scm.domain.privilege.Privilege;
import reece.pro.scm.privilege.annotation.AnnotationParse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @filename PrivilegeInterceptor.java
 * @author Reece
 * @description  
 * @version 
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//得到用户的权限
		Collection<Privilege> privileges = (Collection<Privilege>) ServletActionContext.getRequest().getSession().getAttribute("func");
		
		if(privileges != null){
			//获取目标方法的注解的name属性
			Class targetClass = invocation.getAction().getClass();
			//获取方法名
			String methodName = invocation.getProxy().getMethod();
			//获取是否需要权限验证
			String accessName = AnnotationParse.parse(targetClass, methodName);
			
			boolean flag = false;
			//如果方法写了注解但没写name属性或者没写注解  权限通过
			if(accessName.length() == 0){
				return invocation.invoke();
			}
			
			//如果注解写了 且name的属性和用户可访问的某个权限相同 则允许访问 否则不允许
			for (Privilege privilege : privileges) {
				if(privilege.getName().equals(accessName)){
					flag = true;
					break;
				}
			}
			
			if(flag){
				return invocation.invoke();
			}
		}
		
		
		//将权限异常输出信息 放入值栈
		ActionContext.getContext().getValueStack().push("您没有访问权限");
		return "privilege_error";		
	}

}
