package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO3 {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public static Connection getConnection() throws Exception{
		//oracle.jdbc.OraclDriver외우기
		//jdbc.oracl.thon:@//localhost:1521/xe 외우기
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection
				("jdbc.oracle.thin:@//localhost:1521/xe","system","123");
		return conn;
	}
	public void insert(VO v) {
		String query ="insert into tbl_member_04(custname,amount)values(?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, v.getCustname());
			pstmt.setInt(2, v.getAmount());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int number() {
		int row = 0;
		String query ="select max(custno) from tbl_member_04";
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
	public List<VO>adlist(){
		List<VO>list = new ArrayList<>();
		String query = "select age frome tbl_member_04";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			// while 다음에 변수 설정과 불러오기 외우기
			while(rs.next()) {
				VO v = new VO();
				v.setAge(rs.getInt("age"));
				list.add(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
