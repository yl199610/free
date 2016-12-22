package com.yc.mybatis.entity;

public class Department {

	private Integer dpid;
	private String dpname;
	
	public Department() {
	}

	public Department(Integer dpid, String dpname) {
		super();
		this.dpid = dpid;
		this.dpname = dpname;
	}

	public Integer getDpid() {
		return dpid;
	}

	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	public String getDpname() {
		return dpname;
	}

	public void setDpname(String dpname) {
		this.dpname = dpname;
	}

	@Override
	public String toString() {
		return "Department [dpid=" + dpid + ", dpname=" + dpname + "]";
	}

}
