package com.hb.struts.action;

import org.apache.log4j.Logger;

import com.hb.struts.model.SimpleDao;
import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.Action;

public class InsertTwoAction implements Action {
	Logger log = Logger.getLogger(this.getClass());
	SimpleVo bean = new SimpleVo();
	
	public SimpleVo getBean() {
		return bean;
	}
	public void setBean(SimpleVo bean) {
		this.bean = bean;
	}
	
	@Override
	public String execute() throws Exception {
		SimpleDao dao = new SimpleDao();
		int result = dao.insertOne(bean);
		if(result>0) return SUCCESS;
		else return INPUT;
	}


}
