package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconntecting4 {
	public static Connection getConnection() throws Exception{
		// oracle.jdbc.OracleDriver
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin@//localhost:1521/xe","syste","123");
		return conn;
	}
}

