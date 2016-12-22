package com.yc.mybatis.service;

import java.util.List;

import com.yc.mybatis.entity.Department;

public interface DpService {

	List<Department> getAllDp();

	boolean addDp(Department dp);

	Department getMsgById(int parseInt);

	boolean modifyDp(Department dp);

	boolean ArchiveDp(int parseInt);


}
