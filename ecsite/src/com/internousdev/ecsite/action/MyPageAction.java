package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

//buyItemComplete.jsp/buyItem.jsp → myPage.jsp or error.jsp
public class MyPageAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {

//		sessionにidキーがない場合
		if(!session.containsKey("id")) {
			return ERROR;
		}

//		削除ボタンが押されていない場合
		if(deleteFlg == null) {
			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();

//			アイテムTBLと購入履歴TBLからユーザーの履歴を複数取得
			myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);

//		削除ボタンが押された場合、削除処理
		} else if(deleteFlg.equals("1")) {
			delete();
		}

		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {

//		idとユーザー名
		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

//		idとユーザー名をキーに削除処理
		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);

//		削除されたレコード数が0より大きい場合
		if(res > 0) {
			myPageList = null;
			setMessage("商品情報を正しく削除しました。");
		} else if(res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}

//	受け取り
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

//	受け取り
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

//	受け渡し
	public ArrayList<MyPageDTO> getMyPageList() {
		return this.myPageList;
	}

//	受け渡し
	public String getMessage() {
		return this.message;
	}

//	受け取り
	public void setMessage(String message) {
		this.message = message;
	}

}
