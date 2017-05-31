package com.hb.struts.action;

import com.hb.struts.model.SimpleDao;
import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.Action;

public class DetailAction implements Action {
	private SimpleVo bean;
	private int sabun;
	
	public SimpleVo getBean() {
		return bean;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	@Override
	public String execute() throws Exception {
		bean = new SimpleDao().selectOne(sabun);
		return SUCCESS;
	}

}
