package com.yc.mybatis.service;

import java.util.List;

import com.yc.mybatis.entity.Manager;
import com.yc.mybatis.entity.Money;
import com.yc.mybatis.entity.PaginationBean;
import com.yc.mybatis.entity.Person;

public interface UserService {

	boolean login(Manager manager);

	boolean addPerson(Person n);

	boolean selectPerson(Person p);

	PaginationBean<Person> listPartUsers(String currPage, String pageSize);

	Person getPersonById(int i);

	boolean modifyUser(Person person);

	boolean ArchivePerson(int i);

	Person getDpNameById(int personid);

	List<Person> getAllPersson();

//	Department getDpNameById(int dpid);


}
