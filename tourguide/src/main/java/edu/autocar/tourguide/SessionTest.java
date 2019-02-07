package edu.autocar.tourguide;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.tourguide.database.ConnectionProvider;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide 
 * SessionTest.java 
 * 2019. 1. 16.
 * 
 * 세션 연결을 테스트한다.
 * </pre> 
 * 
 * 
 */
public class SessionTest {
	public static void main(String[] args) {
		SqlSession session = ConnectionProvider.getSqlSession();
		
		//참이면 통과, false 면 예외를 던짐
		//반드시 통과가 되어야 할 때 사용
		assert session != null : "session fail";
		System.out.println("session success");
		session.close();
	}
}
