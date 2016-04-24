	package reece.pro.scm.business.xsgl.action;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import reece.pro.scm.business.xsgl.service.XsyddService;
import reece.pro.scm.domain.business.xsgl.Xsyddzhib;
import reece.pro.scm.domain.business.xsgl.Xsyddzhub;
import reece.pro.scm.privilege.annotation.PrivilegeInfo;
import reece.pro.scm.query.PageResult;
import reece.pro.scm.query.business.xsgl.XsyddzhibQuery;
import reece.pro.scm.query.business.xsgl.XsyddzhubQuery;


import com.opensymphony.xwork2.ActionContext;

@Controller("xsyddAction")
@Scope("prototype")
public class XsyddAction{
	/**
	 * 主表的查询条件
	 */
	private XsyddzhubQuery query_zhub = new XsyddzhubQuery();
	
	/**
	 * 子表的查询条件
	 */
	private XsyddzhibQuery query_zhib = new XsyddzhibQuery();

	/**
	 * 在增加的时候，接受页面上子表的表格中的值
	 */
	private List<Xsyddzhib> xsyddzhibs;
	

	public List<Xsyddzhib> getXsyddzhibs() {
		return xsyddzhibs;
	}
	public void setXsyddzhibs(List<Xsyddzhib> xsyddzhibs) {
		this.xsyddzhibs = xsyddzhibs;
	}

	public XsyddzhubQuery getQuery_zhub() {
		return query_zhub;
	}
	public void setQuery_zhub(XsyddzhubQuery query_zhub) {
		this.query_zhub = query_zhub;
	}
	public XsyddzhibQuery getQuery_zhib() {
		return query_zhib;
	}
	public void setQuery_zhib(XsyddzhibQuery query_zhib) {
		this.query_zhib = query_zhib;
	}
	@Resource(name="xsyddService")
	private XsyddService xsyddService;
	/**
	 * 查询销售预订单
	 * @return
	 */
	@PrivilegeInfo(name="销售预订单管理")
	public String showXsydd(){
		System.err.println(query_zhub.getDdh());
		PageResult<Xsyddzhub> pageResult_zhu = this.xsyddService.findPageResultZhu(query_zhub);
		PageResult<Xsyddzhib> pageResult_zhi = this.xsyddService.findPageResultZi(query_zhib);
		
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhu);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhi);
		
		return "listXsydd";
	}
	
	/**
	 * 跳转到添加页面
	 */
	@PrivilegeInfo(name="销售预订单管理")
	public String addUI(){
		return "xsyddAddUI";
	}
	
	@PrivilegeInfo(name="销售预订单管理")
	public String add(){
		Xsyddzhub xsyddzhub = new Xsyddzhub();
		BeanUtils.copyProperties(this.query_zhub, xsyddzhub);
		//设置销售预订单的最新的订单号
		xsyddzhub.setDdh(this.xsyddService.getMax());
		//建立销售预订单主表和子表的关系
		xsyddzhub.setXsyddzhibs(new HashSet<Xsyddzhib>(this.xsyddzhibs));
		
		this.xsyddService.saveEntry_zhu(xsyddzhub);
		return "action2action";
	}
}
