package reece.pro.scm.test.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
	public static ApplicationContext applicationContext;
	
	static{
		applicationContext = new ClassPathXmlApplicationContext("reece/pro/scm/spring/applicationContext.xml");
		
	}
}
