package br.com.fiap.fase7cap11.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DbConnection {
	
	private static String url = Params.dbUrl;
	private static String username = Params.dbUser;
	private static String password = Params.dbPassword;
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if(connection == null) {
			DriverManager.registerDriver(new OracleDriver());
			return DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
}
