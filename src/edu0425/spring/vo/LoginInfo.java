package edu0425.spring.vo;

public class LoginInfo {
	//存储登录信息
	//登录账号
	private String loginId;
	//登录密码
	private String password;
	//是否记住登录状态
	private boolean remember;
	//用户昵称
	private String username;
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRemember() {
		return remember;
	}
	public void setRemember(boolean remember) {
		this.remember = remember;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
