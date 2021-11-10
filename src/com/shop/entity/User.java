package com.shop.entity;

public class User {
	private Integer userid;
	private String username;
	private String password;
	private Integer usersex;		// 0 男 1女 2 保密
	private String phone;
	private String address;
	
	
	public User(Integer userid, String username, String password, Integer usersex, String phone, String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.usersex = usersex;
		this.phone = phone;
		this.address = address;
	}
	
	public User(String username, String password, Integer usersex, String phone, String address) {
		super();
		this.username = username;
		this.password = password;
		this.usersex = usersex;
		this.phone = phone;
		this.address = address;
	}
	/**
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the usersex
	 */
	public Integer getUsersex() {
		return usersex;
	}
	/**
	 * @param usersex the usersex to set
	 */
	public void setUsersex(Integer usersex) {
		this.usersex = usersex;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
}
