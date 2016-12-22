package com.yc.mybatis.mapper;

import java.util.List;

import com.yc.mybatis.entity.Manager;
import com.yc.mybatis.entity.Money;
import com.yc.mybatis.entity.PaginationBean;
import com.yc.mybatis.entity.Person;

public interface UserMapper {

	Manager findUser(Manager manager);

	boolean insertPerson(Person n);

	Person loginPerson(Person p);

	PaginationBean<Person> getUsersByPagination(PaginationBean<Person> userBean);

	Person getOnePerson(int pid);

	int updateUser(Person person);

	int archOnePerson(int pid);
	
	Person getDpById(int pid);

	List<Person> getPersonAll();

}
