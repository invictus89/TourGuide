package edu.autoar.base.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import edu.autoar.base.util.Resource;

public class ConnectionProvider {
	
	private static Connection conn;
	
	static {
		try {
			Properties props = Resource.getProperties("/database.properties");
			
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			
			 conn = (Connection) DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			System.out.println("뭐가 오류야");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static Connection getConnection() {
		
		return conn;
	}
	
	public static void close() {
		try {
			if(conn!=null) {
				conn.close();
			}
		}catch(SQLException e) {
			System.out.println("error : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
