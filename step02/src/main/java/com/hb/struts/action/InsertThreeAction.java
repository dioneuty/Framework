package com.hb.struts.action;

import org.apache.log4j.Logger;

import com.hb.struts.model.SimpleDao;
import com.hb.struts.model.SimpleVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class InsertThreeAction implements Action, ModelDriven {
	Logger log = Logger.getLogger(this.getClass());
	SimpleVo bean = new SimpleVo();
		
	@Override
	public String execute() throws Exception {
		log.debug(bean);
		SimpleDao dao = new SimpleDao();
		int result = dao.insertOne(bean);
		if(result>0) return SUCCESS;
		else return INPUT;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
