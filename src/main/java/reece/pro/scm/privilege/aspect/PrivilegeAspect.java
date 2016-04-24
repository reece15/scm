package reece.pro.scm.privilege.aspect;

import java.lang.annotation.Annotation;
import java.util.Collection;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;

import reece.pro.scm.domain.privilege.Privilege;
import reece.pro.scm.privilege.annotation.AnnotationParse;


@Aspect
@Component
public class PrivilegeAspect {
	@Pointcut("execution(* reece.pro.scm.*.action.*.*(..))")
	private void accessMethod(){}
	
	@Around("accessMethod()")
	public Object accessTargetMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		Collection<Privilege> privileges = (Collection<Privilege>) ServletActionContext.getRequest().getSession().getAttribute("func");
		if(privileges != null){
			Class targetClass = joinPoint.getTarget().getClass();
			String methodName = joinPoint.getSignature().getName();
			String acMethod = AnnotationParse.parse(targetClass, methodName);
			if(acMethod.length() == 0 ){
				return joinPoint.proceed();
			}
			boolean flag = false;
			for (Privilege privilege : privileges) {
				if(privilege.getName().equals(acMethod)){
					flag = true;
					break;
				}
			}
			
			if(flag){
				return joinPoint.proceed();
			}
		}
		
		ActionContext.getContext().getValueStack().push("你没有权限访问");
		return "privilege_error";
		
	}
}
