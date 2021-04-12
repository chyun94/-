package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBconntecting {
	//멤버 변수로
	Connection conn =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin@//localhost:1521/xe","system","123");
		return conn;
	}
	// 등록 메소드
	public void insert(VO v) {
		String query="";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, v.getCustname());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 번호 자동 생성
	public int number() {

		int row =0;
		String query = "";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				row = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	
	// 목록 메소드
	public List<VO> klist(){	
		List<VO> list = new ArrayList<VO>();
		String query = "";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VO k = new VO();
				k.setAge(rs.getInt("age"));
				list.add(k);
			}
					
		} catch (Exception e) {

		}
		return list;
	}
	
	
}

