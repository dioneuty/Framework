package com.hb.struts.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.hb.struts.model.SimpleDao;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action {
	Logger log = Logger.getLogger(this.getClass());
	private List alist;
	
	public List getAlist() {
		return alist;
	}
	
	@Override
	public String execute() throws Exception {
		log.debug("리스트액션 수행");
		alist = new SimpleDao().selectAll();
		return SUCCESS;
	}
}
