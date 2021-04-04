package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","123");
		return conn;
	}
	public void insert(VO v) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String query = "insert into tbl_member_04(custno,custname,phone,gender,joindate,grade,city)values(?,?,?,?,?,?,?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,v.getCustno());
			pstmt.setString(2,v.getCustname());
			pstmt.setString(3,v.getPhone());
			pstmt.setString(4,v.getGender());
			pstmt.setString(5,v.getJoindate());
			pstmt.setString(6,v.getGrade());
			pstmt.setString(7,v.getCity());			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	//번호 자동발생
	public int custinsert() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;
		
		String query="select max(custno) from tbl_member_04";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
}
