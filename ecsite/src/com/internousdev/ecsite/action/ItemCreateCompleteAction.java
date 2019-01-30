package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private ItemCreateCompleteDAO itemCreateCompleteDAO = new ItemCreateCompleteDAO();

	public String execute() throws SQLException {

//		新規商品登録処理
		itemCreateCompleteDAO.itemCreateInfo(session.get("itemName").toString(), session.get("itemPrice").toString(), session.get("itemStock").toString());
		String result = SUCCESS;
		return result;
	}

//	受け取り
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
