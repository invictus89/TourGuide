package edu.autocar.tourguide.database;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide.database 
 * ConnectionProvider.java 
 * 2019. 1. 16.
 * 
 * mybatis 라이브러리 활용을 위한 sqlSession을 정의한다.
 * 한 번 생성후 지속적인 활용을 위하여 싱글톤으로 구성된다.
 * </pre> 
 * 
 * 
 */
public class ConnectionProvider {
	
	private static SqlSession sqlSession;
	static {
		try {
			String resource = "mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		return sqlSession;
	}
	public ConnectionProvider() {
		// TODO Auto-generated constructor stub
	}

}
