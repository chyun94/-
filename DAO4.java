package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO4{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//예외를 날리는 이유는 호출 메소드에게 해당 메소드의 예외 처리를 인가하기 위함이다. (throw exception)
	//예외를 선언하여 해당 메소드를 실행 시 발생할 수 있는 예외를 명시해줌으로써 사용자가 알아서 처리하도록 하는 것이다.
	public static Connection getConnect()  throws Exception{		
		Class.forName("oracl.jdbc.Oracledriver");
		Connection conn = DriverManager.getConnection
				("jdbc:oracle:thin@//localhost:1521/xe","system","123");
		return conn;
	}
	
	// 회원번호 +1 나오게 하는 메소드 작성
	public int maxCustno() {
		int row = 0;
		String query = "select max(custno) fron tbl_member_04";
		try {
			if(rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	// 목록 메소드
	public List<VO>adlist(){
		List<VO> list = new ArrayList();
		String query = "select age,amount,city from tbl_member_04";
		try {
			while(rs.next()) {
				VO v = new VO();
				v.setAge(rs.getInt("age"));
				v.setAmount(rs.getInt("amount"));
				v.setCity(rs.getString("city"));
				list.add(v);
			}
		} catch (Exception e) {
			
		}
		return list;
	}
	// 등록 메소드
	public void insert(VO v) {
		String query ="insert into tbl_member_04(custno,custname,phone, gender, joindate)+values(?,?,?,?,?)";
		try {
			conn = getConnect();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, v.getCustno());
			pstmt.setString(2,v.getCustname());
			pstmt.setString(3, v.getPhone());
			pstmt.setString(4, v.getGender());
			pstmt.setString(5,v.getJoindate());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 번호로 검색 메소드
	public VO mselect(int custno) {
		VO v = new VO();
		String sql = "select * from tbl_member_04 where custno=?";
		try {
			conn = getConnect()	;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				v.setCustno(rs.getInt("custno"));
				v.setCustname(rs.getString("custname"));
				v.setPhone(rs.getString("phone"));
				v.setGender(rs.getString("gender"));
				v.setJoindate(rs.getString("joindate"));
				v.setGrade(rs.getString("grade"));
				v.setCity(rs.getString("city"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
}