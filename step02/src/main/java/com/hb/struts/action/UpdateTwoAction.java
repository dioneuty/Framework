package com.hb.struts.action;

import org.apache.log4j.Logger;

import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateTwoAction extends ActionSupport {
	private Logger log = Logger.getLogger(this.getClass());
	private SimpleVo bean = new SimpleVo();
	
	public SimpleVo getBean() {
		return bean;
	}
	public void setBean(SimpleVo bean) {
		this.bean = bean;
	}
	
	private Boolean isValidate(){
		if(bean.getSabun() == 0) return false;
		if(bean.getName() == null || "".equals(bean.getName())) return false;
		if(bean.getPay() ==0) return false;
		return true;
	}
	
	@Override
	public String execute() throws Exception {
		log.debug(bean.getSabun() + "," + bean.getName() + "," + bean.getPay());
		if(isValidate()) return SUCCESS;
		else return INPUT;
	}
}
