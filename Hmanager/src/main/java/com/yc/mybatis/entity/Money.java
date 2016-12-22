package com.yc.mybatis.entity;

public class Money {
	private Integer paid;
	private String pamoney;
	private Integer punishaward_id;
	private String moneymonth;
	private Person person;
	
	public Money() {
	}

	public Money(Integer paid, String pamoney, Integer punishaward_id, String moneymonth) {
		super();
		this.paid = paid;
		this.pamoney = pamoney;
		this.punishaward_id = punishaward_id;
		this.moneymonth = moneymonth;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Integer getPaid() {
		return paid;
	}
	public void setPaid(Integer paid) {
		this.paid = paid;
	}
	public String getPamoney() {
		return pamoney;
	}
	public void setPamoney(String pamoney) {
		this.pamoney = pamoney;
	}
	public Integer getPunishaward_id() {
		return punishaward_id;
	}
	public void setPunishaward_id(Integer punishaward_id) {
		this.punishaward_id = punishaward_id;
	}
	
	public String getMoneymonth() {
		return moneymonth;
	}

	public void setMoneymonth(String moneymonth) {
		this.moneymonth = moneymonth;
	}

	@Override
	public String toString() {
		return "Money [paid=" + paid + ", pamoney=" + pamoney + ", punishaward_id=" + punishaward_id + ", moneymonth="
				+ moneymonth + ", person=" + person + "]";
	}

}
