package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

//login.jsp → buyItem.jsp or login.jsp
public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
//	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute() {
//		errorの場合login.jspへ
		String result = ERROR;
		LoginDTO loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

//		ユーザー情報をLoginDTOの型で記憶
		session.put("loginUser", loginDTO);

//		管理者画面分岐を追加、条件はフラグに値があるか
		if(((LoginDTO)session.get("loginUser")).getAdminFlg() != null
		&& (!((LoginDTO)session.get("loginUser")).getAdminFlg().isEmpty())) {

//			管理者フラグを記憶
			session.put("adminFlg",loginDTO.getAdminFlg());

//			admin.jspへ
			return "admin";
		}

//		キャストしながらloginFlgを取得、true/false形式
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()) {

//			successの場合、buyItem.jspへ
			result = SUCCESS;

//			アイテム情報取得
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

//			ユーザー名、id、アイテム名、金額を記憶
			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			return result;
		}
		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

//	受け取り
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
