package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//buyItem.jsp → buyItemConfirm.jsp or buyItem.jsp
public class BuyItemAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private int count;
	private String pay;

	public String execute() {

//		buyItemConfirm.jspへ
		String result = SUCCESS;

//		選択された個数を記憶
		session.put("count",count);

//		オブジェクト型で格納されている個数、金額をint型に変換
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());

//		合計額を記憶
		session.put("total_price", intCount * intPrice);

//		選択された支払い方法を記憶
		String payment;
		if(pay.equals("1")) {
			payment = "現金払い";
			session.put("pay", payment);
		} else {
			payment = "クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

//	受け取り
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
