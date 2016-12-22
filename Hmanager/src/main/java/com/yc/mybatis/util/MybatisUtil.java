package com.yc.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;

public class MybatisUtil {
	private static SqlSessionFactory factory;
	
	static{
		InputStream in=null;
		//加载类路径下的mybatis框架的配置文件
		try {
			in=Resources.getResourceAsStream("mybatis.xml");
			LogManager.getLogger().debug("加载类路径下的mybatis框架的配置文件成功...");
		} catch (IOException e) {
			LogManager.getLogger().debug("加载类路径下的mybatis框架的配置文件失敗...");
		}
		//根據加載上來的mybatis配置文件信息,构建sqlSessionFactory的对象
		factory=new SqlSessionFactoryBuilder().build(in);
		LogManager.getLogger().debug("根據加載上來的mybatis配置文件信息 ");
	}
	
	//取到数据库连接  在插入数据时不自动提交 造成插入数据不成功
	public static SqlSession getSession(){
		SqlSession session=null;
		if(factory!=null){
			session=factory.openSession();
			LogManager.getLogger().debug("使用sqlsession的对象生产出对象");
		}
		return session;
	}
	//取到数据库会话对象
	public static SqlSession getAutoCommitSession(){
		SqlSession session=null;
		if(factory!=null){
			session=factory.openSession(true);
			LogManager.getLogger().debug("使用sqlsession的对象生产出对象");
		}
		return session;
	}
	
	
}
