package com.yc.mybatis.service.impl;

import java.util.List;

import com.yc.mybatis.entity.Manager;
import com.yc.mybatis.entity.Money;
import com.yc.mybatis.entity.PaginationBean;
import com.yc.mybatis.entity.Person;
import com.yc.mybatis.mapper.UserMapper;
import com.yc.mybatis.service.UserService;
import com.yc.mybatis.util.MybatisUtil;

public class UserServiceImpl implements UserService{

	private UserMapper userMapper;
	
	public UserServiceImpl() {
		userMapper=MybatisUtil.getAutoCommitSession().getMapper(UserMapper.class);
	}
	@Override
	public boolean login(Manager manager) {
		return userMapper.findUser(manager)!=null;
	}
	@Override
	public boolean addPerson(Person n) {
		return userMapper.insertPerson(n);
	}
	@Override
	public boolean selectPerson(Person p) {
		return userMapper.loginPerson(p)!=null;
	}
	@Override
	public PaginationBean<Person> listPartUsers(String currPage, String pageSize) {
		PaginationBean<Person> userBean=new PaginationBean<Person>();
		if(currPage!=null){
			userBean.setCurrPage(Integer.parseInt(currPage));
		}
		if(pageSize!=null){
			userBean.setPageSize(Integer.parseInt(pageSize));
		}
		return userMapper.getUsersByPagination(userBean);
	}
	@Override
	public Person getPersonById(int pid) {
		return userMapper.getOnePerson(pid);
	}
	@Override
	public boolean modifyUser(Person person) {
		return userMapper.updateUser(person)>0;
	}
	@Override
	public boolean ArchivePerson(int pid) {
		return userMapper.archOnePerson(pid)>0;
	}
//	@Override
//	public Department getDpNameById(int dpid) {
//		return dpMapper.getDpNameByPid(dpid);
//	}
	@Override
	public Person getDpNameById(int personid) {
		return userMapper.getDpById(personid);
	}
	@Override
	public List<Person> getAllPersson() {
		return userMapper.getPersonAll();
	}

}
