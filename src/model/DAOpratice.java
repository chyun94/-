package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOpratice {
	public static Connection getConnection()throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin@//localhost:1521/xe","system","123");
		return conn;
	}
	//모든 메소드에서 null값을 주는 이유는?
	
	//회원 등록 메소드
	public void insert(VO v) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query="";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, v.getCustno());
			pstmt.setString(2, v.getCustname());
			pstmt.setString(3, v.getPhone());
			pstmt.setString(4, v.getGender());
			pstmt.setString(5, v.getJoindate());
			pstmt.setString(6, v.getGender());
			pstmt.setString(7, v.getCity());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 번호 자동 발생
	public int number() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		int row = 0;
		String query="select max(custno) from tbl_member_04";
		
		try {
			conn =getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				row = rs.getInt(1);
			}
					
		} catch (Exception e) {
			
		}
		return row;
	}
	
	// 회원 목록 메소드
	public List<VO> mlist(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		List<VO>list = new ArrayList<>();
		String query="";
		
		try {
			conn =getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				VO m = new VO();
				m.setSaleno(rs.getInt("saleno"));
				m.setCustname(rs.getString("custname"));
				m.setSdate(rs.getString("sdate"));
				m.setPname(rs.getString("pname"));
				m.setAmount(rs.getInt("amount"));
				m.setPcost(rs.getInt("pcost"));
				
				list.add(m);				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	// 회원 전체 점수,이름,날짜 목록 리스트
	public List<VO> tlist(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VO>list = new ArrayList<VO>();
		String query="";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VO e = new VO();
				e.setTot(rs.getInt("tot"));
				e.setCustname(rs.getString("custname"));
				e.setSdate(rs.getString("sdate"));
				list.add(e);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	// 갯수랑 이름 리스트
	public List<VO> list(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<VO>list = new ArrayList<VO>();
		String query ="";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VO v = new VO();
				v.setPname(rs.getString("pname"));
				v.setSaleno(rs.getInt("saleno"));
				list.add(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}
}
