package com.yc.mybatis.service.impl;

import java.util.List;

import com.yc.mybatis.entity.Department;
import com.yc.mybatis.entity.Person;
import com.yc.mybatis.mapper.DpMapper;
import com.yc.mybatis.mapper.UserMapper;
import com.yc.mybatis.service.DpService;
import com.yc.mybatis.util.MybatisUtil;

public class DpServiceImpl implements DpService {

	private DpMapper dpMapper;
	
	public DpServiceImpl() {
		dpMapper=MybatisUtil.getAutoCommitSession().getMapper(DpMapper.class);
	}
	@Override
	public List<Department> getAllDp() {
		return dpMapper.getAllDpName();
	}
	@Override
	public boolean addDp(Department dp) {
		if(dpMapper.selectByDpName(dp.getDpname())!=null){
			return false;
		}else{
			return dpMapper.insertDp(dp);
		}
	}
	@Override
	public Department getMsgById(int dpid) {
		return dpMapper.getNameAndMan(dpid);
	}
	@Override
	public boolean modifyDp(Department dp) {
		return dpMapper.updateDp(dp);
	}
	@Override
	public boolean ArchiveDp(int parseInt) {
		return dpMapper.DelDp(parseInt)>0;
	}

}
