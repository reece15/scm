package reece.pro.scm.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import reece.pro.scm.domain.basedata.Department;
import reece.pro.scm.query.BaseQuery;

/**
 * @filename DepartmentQuery.java
 * @author Reece
 * @description  
 * @date 2016-3-26下午5:37:25
 * @version 1.0
 */
public class DepartmentQuery extends BaseQuery {
	private Department department;
	
	
	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.department.getName())){
			this.getQueryMap().put("name", this.department.getName());
		}
		if (StringUtils.isNotBlank(this.getDepartment().getDescription())) {
			this.getQueryMap().put("description", this.department.getDescription());
		}
		return this.getQueryMap();
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
