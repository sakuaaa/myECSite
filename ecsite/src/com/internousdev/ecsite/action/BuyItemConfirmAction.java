package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

//buyItemConfirm.jsp → buyItemComplete.jsp or buyItem.jsp
public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public String execute() throws SQLException {

//		購入履歴の追加処理
		buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("login_user_id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("pay").toString());

//		buyItemComplete.jspに画面遷移
		String result = SUCCESS;
		return result;

	}

//	受け取り
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
