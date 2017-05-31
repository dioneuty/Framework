package com.hb.struts.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {
	private Logger log = Logger.getLogger(this.getClass());
	private int sabun;
	private String name;
	private int pay;
	
	public void setLog(Logger log) {
		this.log = log;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
	
	private Boolean isValidate(){
		if(sabun == 0) return false;
		if(name == null || "".equals(name)) return false;
		if(pay==0) return false;
		return true;
	}
	
	@Override
	public String execute() throws Exception {
		log.debug(sabun + "," + name + "," + pay);
		if(isValidate()) return SUCCESS;
		else return INPUT;
	}
}
