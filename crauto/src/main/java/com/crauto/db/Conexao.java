package com.crauto.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao{

	public Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/crautoteste", "root", "");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}