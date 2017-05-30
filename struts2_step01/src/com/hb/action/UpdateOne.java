package com.hb.action;

import java.util.Map;

import com.hb.model.SimpleDao;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateOne extends ActionSupport{	
	private String name, nalja;
	private int sabun, pay;
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNalja(String nalja) {
		this.nalja = nalja;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
	
	@Override
	public String execute() throws Exception {
		SimpleDao dao = new SimpleDao();
		int result = dao.updateOne(sabun,name,nalja,pay);
		System.out.println("1이면 수정 성공: " + result);
		result = 0;
		if(result > 0){
			return this.SUCCESS;
		}else{
			return this.INPUT;
		}
	}
}
