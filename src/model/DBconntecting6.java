package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBconntecting6 {
	//멤버변수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public static Connection getConnection ()throws Exception{
		//Driver이니 Drive와 헷갈리지 않기
		Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection
					("jdbc:oracle:thin@//localhost:1521/xe","system","123");
			return conn;
		}
		
		// 등록 메소드
		public void insert(VO v) {
			String query = "insert into tbl_member_04 (custname,amount) values(?,?)";
			
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
		
		// 번호 자동 생성 메소드
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
				e.printStackTrace();
			}
			return row;
		}
		// 목록 메소드
			public List<VO>kinglist(){
				List<VO> list = new ArrayList<>();
				String query = "select * from tbl_member_04";
				try {
					conn = getConnection();
					pstmt = conn.prepareStatement(query);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						VO v = new VO();
						v.setAge(rs.getInt("age"));
						v.setAmount(rs.getInt("amount"));
						v.setCustname(rs.getString("custname"));
						list.add(v);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			
	}
	
}

