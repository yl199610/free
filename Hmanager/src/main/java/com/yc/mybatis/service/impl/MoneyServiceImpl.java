package com.yc.mybatis.service.impl;

import java.util.List;

import com.yc.mybatis.entity.Money;
import com.yc.mybatis.entity.Person;
import com.yc.mybatis.mapper.MoneyMapper;
import com.yc.mybatis.service.MoneyService;
import com.yc.mybatis.util.MybatisUtil;

public class MoneyServiceImpl implements MoneyService {
	private MoneyMapper moneyMapper;
	
	public MoneyServiceImpl() {
		moneyMapper=MybatisUtil.getAutoCommitSession().getMapper(MoneyMapper.class);
	}
	@Override
	public boolean addMoney(Money money) {
		return moneyMapper.insertMoney(money);
	}
	@Override
	public List<Money> getAllMoney() {
		return moneyMapper.getAllM();
	}
	@Override
	public Money getMsgById(int paid) {
		return moneyMapper.getById(paid);
	}
	@Override
	public Person getById(int parseInt) {
		return moneyMapper.getDpNameById(parseInt);
	}
	@Override
	public boolean modifyMoney(Money dp) {
		return moneyMapper.updateMoney(dp);
	}
	@Override
	public boolean ArchiveMoney(int parseInt) {
		return moneyMapper.delMoney(parseInt);
	}
	@Override
	public List<Money> getAllMoneyByid(int parseInt) {
		return moneyMapper.getMoneyById(parseInt);
	}

}
