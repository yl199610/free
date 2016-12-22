package com.yc.mybatis.entity;

public class Manager {
	private Integer mid;
	private String username;
	private String pwd;
	private String upower;
	
	public Manager() {
	}
	
	public Manager(Integer mid, String username, String pwd, String upower) {
		this.mid = mid;
		this.username = username;
		this.pwd = pwd;
		this.upower = upower;
	}

	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUpower() {
		return upower;
	}
	public void setUpower(String upower) {
		this.upower = upower;
	}

	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", username=" + username + ", pwd=" + pwd + ", upower=" + upower + "]";
	}
	
}
