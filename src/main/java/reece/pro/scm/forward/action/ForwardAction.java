package reece.pro.scm.forward.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @filename ForwardAction.java
 * @author Reece
 * @description  
 * @version 
 */

public class ForwardAction extends ActionSupport {
	private String method;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public String forward(){
		return method;
	}
}
