package uk.sevensixtwo.backend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection;
		
		try{
			String connectionURL = "jdbc:mysql://138.68.174.176:3306/ProjectWork";
			connection = DriverManager.getConnection(connectionURL, "SST", "******412");
			return connection;
		} catch (SQLException exx) {
			throw exx;
		}
	}
}