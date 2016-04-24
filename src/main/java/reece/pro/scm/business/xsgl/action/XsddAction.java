package reece.pro.scm.business.xsgl.action;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import reece.pro.scm.business.xsgl.service.XsddService;
import reece.pro.scm.business.xsgl.service.XsyddService;
import reece.pro.scm.domain.business.xsgl.Xsddzhib;
import reece.pro.scm.domain.business.xsgl.Xsddzhub;
import reece.pro.scm.query.PageResult;
import reece.pro.scm.query.business.xsgl.XsddzhibQuery;
import reece.pro.scm.query.business.xsgl.XsddzhubQuery;

/**
 * @filename XsddAction.java
 * @author Reece
 * @description  
 * @version 
 */
@Controller("xsddAction")
@Scope("prototype")
public class XsddAction {
	@Resource(name="xsddService")
	private XsddService xsddService;
	
	
	private XsddzhubQuery query_zhub = new XsddzhubQuery();
	private XsddzhibQuery query_zhib = new XsddzhibQuery();
	
	private List<Xsddzhib> xsddzhibs;

	
	public XsddService getXsddService() {
		return xsddService;
	}

	public void setXsddService(XsddService xsddService) {
		this.xsddService = xsddService;
	}

	public XsddzhubQuery getQuery_zhub() {
		return query_zhub;
	}

	public void setQuery_zhub(XsddzhubQuery query_zhub) {
		this.query_zhub = query_zhub;
	}

	public XsddzhibQuery getQuery_zhib() {
		return query_zhib;
	}

	public void setQuery_zhib(XsddzhibQuery query_zhib) {
		this.query_zhib = query_zhib;
	}

	public List<Xsddzhib> getXsddzhibs() {
		return xsddzhibs;
	}

	public void setXsddzhibs(List<Xsddzhib> xsddzhibs) {
		this.xsddzhibs = xsddzhibs;
	}
	
	public String showXsdd(){
		PageResult<Xsddzhub> pageResult_zhu = this.xsddService.findPageResultZhu(query_zhub);
		PageResult<Xsddzhib> pageResult_zhi = this.xsddService.findPageResultZi(query_zhib);
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhu);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhi);
		return "xsddList";
	}
	
	public String addUI(){
		return "addUI";
	}
	
	public String add(){
		Xsddzhub xsddzhub = new Xsddzhub();
		BeanUtils.copyProperties(this.query_zhub, xsddzhub);
		
		xsddzhub.setDdh(this.xsddService.getMax());
		xsddzhub.setXsddzhibs(new HashSet<Xsddzhib>(this.xsddzhibs));
		
		this.xsddService.saveEntry_zhu(xsddzhub);
		return "action2action";
	}
}
