package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.p;

public class DBconntecting3 {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin@//localhost:1521/xe","sysytem","123");
		return conn;
	}
	public void insert(VO v) {
		String query=" insert into tbl_member_04(custname)values(?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, v.getCustname());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int number() {
		int row =0;
		String query ="select max(custno) from tbl_member_04";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			
		}
		return row;
	}
	
	public List<VO>asdlist(){
		List<VO> list = new ArrayList<VO>();
		String query = "select * from tbl_member_04";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
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

