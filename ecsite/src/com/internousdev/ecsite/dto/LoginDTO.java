package com.internousdev.ecsite.dto;

public class LoginDTO {

	private String loginId;
	private String userName;
	private String loginPassword;
//	管理者フラグを追加
	private String adminFlg;
	private boolean loginFlg = false;

//	id
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

//	ユーザー名
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	ログインパスワード
	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

//	管理者フラグ
	public String getAdminFlg() {
		return adminFlg;
	}

	public void setAdminFlg(String adminFlg) {
		this.adminFlg = adminFlg;
	}

//	ログイン済フラグ
	public boolean getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
}
