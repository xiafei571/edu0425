package edu0425.spring.vo;

import java.util.Date;

public class UserInfo {
	//1
	private Integer uid;
	//2
	private String loginId;
	//3
	private String userName;
	//4
	private String password;
	//5
	private String email;
	//6
	private String phone;
	//7
	private Integer valid;
	//8
	private Date gmt_create;
	//9
	private Date gmt_modified;
	//10
	private Integer onOff;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public Date getGmt_create() {
		return gmt_create;
	}
	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
	}
	public Date getGmt_modified() {
		return gmt_modified;
	}
	public void setGmt_modified(Date gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
	public Integer getOnOff() {
		return onOff;
	}
	public void setOnOff(Integer onOff) {
		this.onOff = onOff;
	}
}
