package model;

import dao.AccountDAO;
import model.bean.AccountBean;

public class LoginLogic {
	// ログインした情報が一致するアカウントがあるか確認
	public boolean findAccount(AccountBean login) {
		AccountDAO dao = new AccountDAO();
		AccountBean account = dao.findByLogin(login);
		return account != null;
	}
	
	// ログイン成功後、セッションスコープに保存するアカウント情報をデータベースから取得
	public AccountBean getAccountInfo(AccountBean login) {
		AccountDAO dao = new AccountDAO();
		AccountBean account = dao.getAccount(login);
		return account;
	}
	
}