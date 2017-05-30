package com.hb.action;

import com.opensymphony.xwork2.ActionSupport;

public class Ex03 extends ActionSupport{
	private String msg;
	
	public String getMsg() {
		return this.msg;
	}
	
	@Override
	public String execute() throws Exception {
		msg="이렇게 전달합니다";
		return this.SUCCESS;
	}
}
