package com.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class Dbutil {

	private static BasicDataSource bds;
	
	static{
		bds=new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/slokam");
		bds.setUsername("root");
		bds.setPassword("sql");
	}
	
	public static Connection getConnection() throws SQLException{
		return bds.getConnection();
		
	}
}
