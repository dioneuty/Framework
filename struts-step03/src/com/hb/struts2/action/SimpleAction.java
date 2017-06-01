package com.hb.struts2.action;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.hb.struts2.model.SimpleDao;
import com.hb.struts2.model.SimpleVo;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SimpleAction{
	private static Logger log = Logger.getLogger(SimpleAction.class);
	private List<SimpleVo> list;
	private int sabun;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	public List<SimpleVo> getList() {
		return list;
	}
	public void setList(List<SimpleVo> list) {
		this.list = list;
	}
	public String execute(){
		return "errors";
	}
	public String list(){
		SimpleDao dao = new SimpleDao();
		try {
			list = dao.seletAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String add(){
		return "success";
	}
	public String insert(){
		return "success";
	}
	public String detail(){
		log.debug("sabun: + sabun");
		return "success";
	}
	public String edit(){
		return "success";
	}
}
