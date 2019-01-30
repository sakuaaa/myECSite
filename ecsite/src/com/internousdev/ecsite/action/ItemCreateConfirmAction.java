package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//ItemCreateAction → itemCreateConfirm.jsp or itemCreate.jsp
public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{

	private String itemName;
	private String itemPrice;
	private String itemStock;
	private Map<String, Object> session;
	private String errorMessage;

	public String execute() {
//		itemCreateConfirm.jspに画面遷移
		String result = SUCCESS;

//		項目がすべて入力されている場合
		if(!(itemName.equals(""))
				&& !(itemPrice.equals(""))
				&& !(itemStock.equals(""))) {

			session.put("itemName", itemName);
			session.put("itemPrice", itemPrice);
			session.put("itemStock", itemStock);
		} else {
//			itemCreate.jsp
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
		return result;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
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
