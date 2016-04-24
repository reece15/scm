package reece.pro.scm.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import reece.pro.scm.domain.basedata.Department;
import reece.pro.scm.domain.basedata.User;
import reece.pro.scm.query.BaseQuery;

/**
 * @filename UserQuery.java
 * @author Reece
 * @description  
 * @date 2016-3-29上午12:22:45
 * @version 
 */
public class UserQuery extends BaseQuery {
	private User user;
	
	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.user.getEmail())){
			this.getQueryMap().put("email", this.user.getEmail());
		}
		if (StringUtils.isNotBlank(this.user.getUsername())) {
			this.getQueryMap().put("username", this.user.getUsername());
		}
		return this.getQueryMap();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
