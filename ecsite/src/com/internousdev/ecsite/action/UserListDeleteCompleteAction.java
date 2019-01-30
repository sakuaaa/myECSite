package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport implements SessionAware{

	private UserListDeleteCompleteDAO deleteDAO = new UserListDeleteCompleteDAO();
	private String message;
	private Map<String, Object> session;
	private int count;

	public String execute() throws SQLException {

//		キャスト時の警告の非表示
		@SuppressWarnings("unchecked")
		Collection<String> checkList = (Collection<String>)session.get("checkList");

		if(checkList == null){
			checkList = new ArrayList<String>();
		}

		for(String id : checkList) {
			System.out.println(id);
			count += deleteDAO.UserHistoryDeleteSelect(id);
		}

		if(count > 0) {
			setMessage("ユーザー情報を正しく削除しました。");
		} else if(count == 0) {
			setMessage("ユーザー情報の削除に失敗しました。");
		}

		return SUCCESS;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
