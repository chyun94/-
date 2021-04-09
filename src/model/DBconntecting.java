package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconntecting {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin@//localhost:1521/xe","system","123");
		return conn;
	}
}

