package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconntecting3 {
	public static Connection getConnection() throws Exception{
		Class.forName("oacle.jdbcOraclManager");
		Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin@//localhost:1521/xe","system","123");
		return conn;
	}
}

