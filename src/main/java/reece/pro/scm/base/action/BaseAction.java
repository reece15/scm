package reece.pro.scm.base.action;

import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @filename BaseAction.java
 * @author Reece
 * @description  把ModelDriven封装 把跳转字符串封装 把得到session封装
 * @date 2016-3-27下午4:21:44
 * @version 
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	private Class clazz;
	private T t;
	private int currentPage;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public BaseAction(){
//		Type ty = this.getClass().getGenericSuperclass();
//		if(ty instanceof ParameterizedType){
//			ParameterizedType type = (ParameterizedType) ty;
//			this.clazz = (Class) type.getActualTypeArguments()[0];
//		}else{
//			this.clazz = ty.getClass();
//		}
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) type.getActualTypeArguments()[0];
		try {
			this.t = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public T getModel() {
		return this.t;
	}
	
	
	private String checkedStr;
	
	private Long[] ids;
	
	
	
	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public String getCheckedStr() {
		return checkedStr;
	}

	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}


	public final static String ADD_UI = "addUI";
	public final static String UPDATE_UI = "updateUI";
	public final static String SAVE_UI = "saveUI";
	public final static String LIST_UI = "listUI";
	public final static String ACTION_2_ACTION = "action2action";
	public String addUI = ADD_UI;
	public String updateUI = UPDATE_UI;
	public String saveUI = SAVE_UI;
	public String listUI = LIST_UI;
	public String action2action = ACTION_2_ACTION;
	
	/**
	 * 
	 *得到session
	 */
	public HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	 
}
