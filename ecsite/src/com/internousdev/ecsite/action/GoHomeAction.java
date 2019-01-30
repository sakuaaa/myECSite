package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//→ home.jsp
public class GoHomeAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	public String execute() {
		return SUCCESS;
	}

//	受け渡し
	public Map<String, Object> getSession() {
		return this.session;
	}

//	受け取り
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
