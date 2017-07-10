package com.example.cloud_config_client.server;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 访问数据库类
 * @author juanjuan
 *
 */
public class DBAccess {
	public SqlSession getSqlSession() throws IOException{
		//通过配置文件获取数据库连接信息
		Reader reader=Resources.getResourceAsReader("cloud_config_client/src/main/resources/application.properties");
		//通过配置信息构建一个SQLSessionFactory
		SqlSessionFactory  sqlSessionFactor = new SqlSessionFactoryBuilder().build(reader);
		//通过sqlSessionFactory打开一个数据会话
		SqlSession sqlSession = sqlSessionFactor.openSession();
	    return sqlSession;
	}

}
