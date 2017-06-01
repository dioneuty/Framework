package com.hb.struts2.action;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.hb.struts2.model.SimpleDao;
import com.hb.struts2.model.SimpleVo;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SimpleAction implements ModelDriven<SimpleVo>, Preparable{
	private static Logger log = Logger.getLogger(SimpleAction.class);
	private List<SimpleVo> list;
	private int sabun;
	private SimpleDao dao = new SimpleDao();
	private SimpleVo bean;
	
	public SimpleVo getBean() {
		return bean;
	}
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
		try {
			list = dao.seletAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String detail(){
		log.debug("sabun: + sabun");
		try {
			bean = dao.selectOne(sabun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String update(){
		log.debug(bean);
		int result=0;
		try {
			result = dao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result>0)
			return "success";
		else
			return "input";
	}
	public String add(){
		return "success";
	}
	public String insert(){
		return "success";
	}
	@Override
	public SimpleVo getModel() {
		return bean;
	}
	@Override
	public void prepare() throws Exception {
		bean = new SimpleVo();
	}
}
