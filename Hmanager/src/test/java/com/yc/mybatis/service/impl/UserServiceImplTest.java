package com.yc.mybatis.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.yc.mybatis.entity.Department;
import com.yc.mybatis.entity.Manager;
import com.yc.mybatis.entity.Person;
import com.yc.mybatis.mapper.DpMapper;
import com.yc.mybatis.mapper.UserMapper;
import com.yc.mybatis.service.UserService;
import com.yc.mybatis.util.MybatisUtil;

public class UserServiceImplTest {

	private UserService userService;
	
	@Test
	public void testConn() {
		//使用sqlsession的对象生产出对象
		SqlSession session=MybatisUtil.getSession();
		//获得数据库连接
		Connection con=session.getConnection();
		assertNotNull(con);
	}
	
	@Before
	public void setUp(){
		userService=new UserServiceImpl();
	}
	@Test
	public void testLogin() {
		Manager user=new Manager();
		user.setMid(1);
		user.setPwd("a");
		user.setUpower("");
		user.setUsername("管理员");
		boolean result=userService.login(user);
		assertEquals(true,result);
	}
	
	@Test
	public void testLogin1() {
		Person user=new Person();
		user.setPid(141666);
		user.setPersonid(300);
		System.out.println(user);
		boolean result=userService.selectPerson(user);
	}
	
	@Test
	public void testGetEmpById() {
		SqlSession session=MybatisUtil.getSession();
		UserMapper em=session.getMapper(UserMapper.class);
		Person emp=em.getDpById(141666);
		System.out.println("================"+emp);
		assertNotNull(emp);
	}
	
	@Test
	public void testGetEmpById1() {
		SqlSession session=MybatisUtil.getSession();
		DpMapper em=session.getMapper(DpMapper.class);
		Department emp=em.selectByDpName("问答部");
		System.out.println("================"+emp);
		assertNotNull(emp);
	}
//	@Test
//	public void testGetEmpById2() {
//		SqlSession session=MybatisUtil.getSession();
//		UserMapper em=session.getMapper(UserMapper.class);
//		Person emp=em.getOneMoney(141666);
//		System.out.println("================"+emp);
//		assertNotNull(emp);
//	}
	
//	@Test
//	public void testGetEmpById3() {
//		SqlSession session=MybatisUtil.getSession();
//		UserMapper em=session.getMapper(UserMapper.class);
//		Person dept=em.getPersonMoney(141666);
//		System.out.println(dept);
//		assertNotNull(dept);
//	}
}
