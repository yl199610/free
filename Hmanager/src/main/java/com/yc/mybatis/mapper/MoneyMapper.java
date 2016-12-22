package com.yc.mybatis.mapper;

import java.util.List;

import com.yc.mybatis.entity.Money;
import com.yc.mybatis.entity.Person;

public interface MoneyMapper {

	boolean insertMoney(Money money);

	List<Money> getAllM();

	Money getById(int paid);

	Person getDpNameById(int parseInt);

	boolean updateMoney(Money dp);

	boolean delMoney(int parseInt);

	List<Money> getMoneyById(int parseInt);

}
