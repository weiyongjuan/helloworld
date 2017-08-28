package com.example.cloud_config_client.entity;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class sysUser implements Serializable {
	
	private Integer userId;
	private String  userName;
	private String  userPassword;
	private String  phone;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "sysUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", phone="
				+ phone + "]";
	}

	
	
	
	

}
