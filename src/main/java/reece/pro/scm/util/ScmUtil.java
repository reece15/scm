package reece.pro.scm.util;

import java.util.Calendar;

/**
 * @filename ScmUtil.java
 * @author Reece
 * @description
 * @version
 */
public class ScmUtil {
	public static String getDateToString() {
		Calendar cal = Calendar.getInstance();// 使用日历类
		int year = cal.get(Calendar.YEAR);// 得到年
		int month = cal.get(Calendar.MONTH) + 1; // 得到月，因为从0开始的，所以要加1
		int day = cal.get(Calendar.DAY_OF_MONTH);// 得到天
		return "" + year + month + day;
	}
	
	public static String getDDH(String type){
		 Calendar cal=Calendar.getInstance();//使用日历类
		  int year=cal.get(Calendar.YEAR);//得到年
		  int month=cal.get(Calendar.MONTH)+1; //得到月，因为从0开始的，所以要加1
		  int day=cal.get(Calendar.DAY_OF_MONTH);//得到天
		 return type+year+month+day;
	}
}
