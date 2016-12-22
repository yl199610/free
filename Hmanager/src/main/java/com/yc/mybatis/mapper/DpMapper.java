package com.yc.mybatis.mapper;

import java.util.List;

import com.yc.mybatis.entity.Department;
import com.yc.mybatis.entity.Person;

public interface DpMapper {

	List<Department> getAllDpName();

	boolean insertDp(Department dp);

	Department getNameAndMan(int dpid);

	boolean updateDp(Department dp);

	List<Person> getPersonName();

	int DelDp(int parseInt);

	Department selectByDpName(String dpname);

}
