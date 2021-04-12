package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBconntecting2 {
	// 멤버 변수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin@//localhost:1521/xe","system","123");
		return conn;
	}
	
	public void insert(VO v) {
		String query = "";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, v.getAmount());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			
		}
	}
	
	public int number() {
		int row = 0;
		String query ="";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return row;
	}
	
	public List<VO> list(){
		List<VO>list = new ArrayList<VO>();
		String query="";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VO l = new VO();
				l.setAge(rs.getInt("age"));
				list.add(l);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
}

