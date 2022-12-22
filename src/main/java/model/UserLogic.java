package model;

import java.util.ArrayList;
import java.util.List;

import dao.AccountDAO;
import model.bean.AccountBean;

public class UserLogic {
	// ユーザ情報取得（全員）
	public List<AccountBean> findAccount() {
		List<AccountBean> userList = new ArrayList<AccountBean>();
		AccountDAO dao = new AccountDAO();
		userList = dao.getAccountAll();
		return userList;
	}
}
