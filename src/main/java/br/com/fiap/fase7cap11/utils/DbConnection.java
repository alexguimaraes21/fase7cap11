package br.com.fiap.fase7cap11.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private static String username = "rm97596";
	private static String password = "211081";
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if(connection == null) {
			return DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
}
