package com.internousdev.ecsite.dto;

public class BuyItemDTO {

	private int id;
	private String itemName;
	private String itemPrice;

//	商品id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	商品名
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

//	金額
	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

}
