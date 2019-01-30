package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//userCreateAction → userCreateConfirm.jsp or userCreate.jsp
public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String, Object> session;
	private String errorMessage;

	public String execute() {
//		userCreateConfirm.jspに画面遷移
		String result = SUCCESS;

//		項目がすべて入力されている場合
		if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))) {

			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
		} else {
//			userCreate.jsp
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
		return result;
	}

////	セッションでの受け渡しに修正
//	public String getLoginUserId() {
//		return loginUserId;
//	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

//	public String getLoginPassword() {
//		return loginPassword;
//	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

//	public String getUserName() {
//		return userName;
//	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	受け取り
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMassage) {
		this.errorMessage = errorMassage;
	}
}
