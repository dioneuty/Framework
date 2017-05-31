package com.hb.struts.action;

import com.hb.struts.model.SimpleDao;
import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.Action;

public class InsertOneAction implements Action {
	SimpleVo bean = new SimpleVo();
	
	@Override
	public String execute() throws Exception {
		SimpleDao dao = new SimpleDao();
		//int result = dao.insertOne(sabun,name,pay);
		SimpleVo bean = new SimpleVo();
		bean.setSabun(sabun);
		bean.setName(name);
		bean.setPay(pay);
		int result = dao.insertOne(bean);
		if(result>0) return SUCCESS;
		else return INPUT;
	}


}
