package com.internousdev.ecsite.dto;

public class MyPageDTO {

	public String itemName;
	public String totalPrice;
	public String totalCount;
	public String payment;
	public String userName;
	public String id;
	public String insert_date;

//	アイテム名
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

//	合計金額
	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

//	個数
	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

//	支払い方法
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

//	ユーザー名
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	購入日付
	public String getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}

}
