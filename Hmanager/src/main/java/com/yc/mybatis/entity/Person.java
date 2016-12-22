package com.yc.mybatis.entity;

import java.util.List;

public class Person {
	private Integer pid;
	private String pname;
	private String idcard;
	private String phonenumber;
	private String sex;
	private String birthday;
	private String photo;
	private Integer personid;
	private String ppower;
	private String address;
	private String position;
	private String empdate;
	private Department department;
	private List<Money> money;
	public Person() {
	}

	public Person(Integer pid, String pname, String idcard, String phonenumber, String sex, String birthday,
			String photo, Integer personid, String ppower, String address, String position, String empdate,
			Department department, List<Money> money) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.idcard = idcard;
		this.phonenumber = phonenumber;
		this.sex = sex;
		this.birthday = birthday;
		this.photo = photo;
		this.personid = personid;
		this.ppower = ppower;
		this.address = address;
		this.position = position;
		this.empdate = empdate;
		this.department = department;
		this.money = money;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getPersonid() {
		return personid;
	}
	public void setPersonid(Integer personid) {
		this.personid = personid;
	}

	public String getPpower() {
		return ppower;
	}

	public void setPpower(String ppower) {
		this.ppower = ppower;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmpdate() {
		return empdate;
	}

	public void setEmpdate(String empdate) {
		this.empdate = empdate;
	}

	public List<Money> getMoney() {
		return money;
	}

	public void setMoney(List<Money> money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", idcard=" + idcard + ", phonenumber=" + phonenumber
				+ ", sex=" + sex + ", birthday=" + birthday + ", photo=" + photo + ", personid=" + personid
				+ ", ppower=" + ppower + ", address=" + address + ", position=" + position + ", empdate=" + empdate
				+ ", department=" + department + ", money=" + money + "]";
	}


}
