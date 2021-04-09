package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconntecting5 {
	public static Connection getConnection( )throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection
				("jdbc:oracl:thin@//localhost:1521/xe","system","123");
		return conn;
	}
}

