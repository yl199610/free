package com.yc.mybatis.service;

import java.util.List;

import com.yc.mybatis.entity.Money;
import com.yc.mybatis.entity.Person;

public interface MoneyService {

	boolean addMoney(Money money);

	List<Money> getAllMoney();

	Money getMsgById(int paid);

	Person getById(int parseInt);

	boolean modifyMoney(Money dp);

	boolean ArchiveMoney(int parseInt);

	List<Money> getAllMoneyByid(int parseInt);

}
