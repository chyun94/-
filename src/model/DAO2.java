package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.k;

public class DAO2 {
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","123");
		return conn;
	}
	//정수 입력 메소드
	public void Intinsert(VO v) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query ="";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, v.getAmount());
			pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 문자열 입력 메소드
	public void Stinginsert (VO v) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, v.getCustname());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 정수,문자열 입력 메소드
	public void siisert (VO v) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, v.getAmount());
			pstmt.setString(2, v.getCustname());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// practice
	public void practice (VO v) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query="";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, v.getAmount());
			pstmt.setString(2, v.getCustname());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//practice2
	public void practice2 (VO v) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query="";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, v.getAmount());
			pstmt.setString(2, v.getCustname());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 자동 발생 메소드 * 쿼리문을 잘 작성 해야한다.
	public int number() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;
		//tbl_number_04로 부터 custno전부를 선택해주는 쿼리문
		String query="select max(custno) from tbl_number_04";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			// 자동 발생 하는문 작성
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	// 자동 발생 하는데 번호가 2씩 커지는 메소드
	public int number2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query="select max(custno) from tbl_number_04";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	// 자동발생 practice
	public int number3() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row=0;
		String query = "select max(custno) from tbl_number_04";
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
	// 자동발생 practice2
	public int number4() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row=0;
		String query="select max(custno)from tbl_numberl_04";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	// 목록을 보여주는 메소드 (VO에서 가져 오는 것)
	public List<VO> list(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VO>list = new ArrayList<VO>();
		String quert = "select * from tbl_number_04";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(quert);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO m = new VO();
				m.setAmount(rs.getInt("amount"));
				m.setCity(rs.getString("city"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// list practice
	public List<VO> mlist(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VO> list = new ArrayList<VO>();
		String query="";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO m = new VO();
				m.setAmount(rs.getInt("amount"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
	// list practice2
	public List<VO>nlist(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VO>list = new ArrayList<VO>();
		String query=" select amount,custname from tbl_number_04";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VO k = new VO();
				k.setAmount(rs.getInt("amount"));
				k.setCustname(rs.getString("custname"));
				list.add(k);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//list practice3
	public List<VO> klist(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VO>list = new ArrayList<VO>();
		String query="select name,score,age,gender from kingdom20210401";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {				
				VO king = new VO();
				king.setName(rs.getString("name"));
				king.setScore(rs.getInt("score"));
				king.setAge(rs.getInt("age"));
				king.setGender(rs.getString("gender"));
				list.add(king);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
