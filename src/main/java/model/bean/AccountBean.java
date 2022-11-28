package model.bean;

import java.io.Serializable;

public class AccountBean implements Serializable {
	private String loginId;
	private String pass;
	private String userName;
	private boolean role;
	
	// コンストラクタ
	public AccountBean() {	
	}
	
	public AccountBean(String loginId, String pass) {
		this.loginId = loginId;
		this.pass = pass;
	}
	
	public AccountBean(String loginId, String pass, String userName, boolean role) {
		this.loginId = loginId;
		this.pass = pass;
		this.userName = userName;
		this.role = role;
	}
	
	// getter / setter
	
	
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public boolean isRole() {
		return role;
	}
	
	public void setRole(boolean role) {
		this.role = role;
	}
	
	
}
