package com.yc.mybatis.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class MybatisUtilTest {

	@Test
	public void testGetSession() {
		assertNotNull(MybatisUtil.getSession().getConnection());
	}

	@Test
	public void testGetAutoCommitSession() {
		assertNotNull(MybatisUtil.getAutoCommitSession().getConnection());
	}

}
