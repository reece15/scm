package reece.pro.scm.privilege.annotation;

import java.lang.reflect.Method;

/**
 * @filename AnnotationParse.java
 * @author Reece
 * @description  
 * @version 
 */
public class AnnotationParse {
	
	/**
	 * 提供一个目标类 提供一个目标方法 获取目标方法上的注解属性的name属性的值
	 * @author Reece
	 * @description 
	 * @param targetClass
	 * @param methodName
	 * @return
	 * @throws Exception
	 */
	public static String parse(Class targetClass, String methodName) throws Exception{
		String accessMethod = "";
		
		Method method = targetClass.getMethod(methodName);
		
		if(method.isAnnotationPresent(PrivilegeInfo.class)){
			PrivilegeInfo privilegeInfo = method.getAnnotation(PrivilegeInfo.class);
			accessMethod = privilegeInfo.name();
		}
		
		return accessMethod;
	}
}
