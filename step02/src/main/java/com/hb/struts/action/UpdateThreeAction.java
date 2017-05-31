package com.hb.struts.action;

import org.apache.log4j.Logger;

import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateThreeAction extends ActionSupport {
	private Logger log = Logger.getLogger(this.getClass());
	private SimpleVo bean = new SimpleVo();
	
	public SimpleVo getBean() {
		return bean;
	}
	public void setBean(SimpleVo bean) {
		this.bean = bean;
	}
	
	
	@Override
	public void validate(){
		if(bean.getSabun() == 0) addFieldError("errSabun", "사번을 입력");
		if("".equals(bean.getName())) addFieldError("errName", "이름을 입력");
		if(bean.getPay() == 0) addFieldError("errPay", "금액을 입력");
	}
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
}
