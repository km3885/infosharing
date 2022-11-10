package model;

import dao.AccountDAO;
import model.bean.AccountBean;
import model.bean.LoginBean;

public class LoginLogic {
	// 
	public boolean execute(LoginBean login) {
		AccountDAO dao = new AccountDAO();
		AccountBean account = dao.findByLogin(login);
		return account != null;
	}
}
