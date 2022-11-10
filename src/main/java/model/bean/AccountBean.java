package model.bean;

import java.io.Serializable;

public class AccountBean implements Serializable {
	private String userId;
	private String pass;
	
	public AccountBean() {
		
	}
	public AccountBean(String userId, String pass) {
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
