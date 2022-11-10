package model.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private String userId;
	private String pass;
	
	public LoginBean() {
		
	}
	
	public LoginBean(String userId, String pass) {
		this.userId = userId;
		this.pass = pass;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
