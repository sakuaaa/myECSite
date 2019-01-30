package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

//home.jsp → login.jsp or buyItem.jsp
public class HomeAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute() {
		String result = "login";

//		idキーが存在している場合、trueを返す(ログイン済み)
		if(session.containsKey("id")) {
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			result = SUCCESS;
		}
//		idがない場合、ログイン画面に遷移、ある場合はbuyItem画面へ
		return result;
	}

//jspでは#sessionで取得するため削除
//	値を受け渡す
//	public Map<String, Object> getSession() {
//		return session;
//	}

//	値を受け取る
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
