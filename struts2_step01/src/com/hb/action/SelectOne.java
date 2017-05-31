package com.hb.action;

import java.util.HashMap;
import java.util.Map;

import com.hb.model.SimpleDao;
import com.opensymphony.xwork2.ActionSupport;

public class SelectOne extends ActionSupport{
	private int sabun;
	private Map<String, Object> bean;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public Map<String, Object> getBean() {
		return bean;
	}
	
	@Override
	public String execute() throws Exception {
		SimpleDao dao = new SimpleDao();
		bean = dao.selectOne(sabun);
		return this.SUCCESS;
	}
}
