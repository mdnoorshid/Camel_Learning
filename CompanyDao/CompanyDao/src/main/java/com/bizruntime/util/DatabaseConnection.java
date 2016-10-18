package com.bizruntime.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DatabaseConnection 
{
static Logger log=Logger.getLogger(DatabaseConnection.class); 

/**
 *Creating JDBC Connection 
 */
	static Connection conn=null;
public static Connection getConnection() throws Exception
{
	// JDBC driver name and database URL
	final String JDBC_DRIVER=new Config().getPropValues("JDBC_DRIVER");
	final String DB_URL=new Config().getPropValues("DB_URL");
	final String USER=new Config().getPropValues("USER");
	final String PASS=new Config().getPropValues("PASS");
	try{
	//Loading Driver Class
	Class.forName(JDBC_DRIVER);
	//Creating Connection
	conn=DriverManager.getConnection(DB_URL,USER,PASS);
	}catch(SQLException e){
		e.printStackTrace();
	}
	return conn;
}
}
