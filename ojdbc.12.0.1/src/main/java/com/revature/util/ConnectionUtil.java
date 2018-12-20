package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	// this is terrible, don't do it!!!
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@vigile-spark-demo.cofotsx6hlk9.us-east-2.rds.amazonaws.com:1521:orcl";
		String user = "admin";
		String pass = "AWSRev2018";
		return DriverManager.getConnection(url, user, pass);
		
	}
	
	public static Connection getConnection(String filename) throws SQLException, IOException {
		Properties prop = new Properties(); 
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
	}
}
