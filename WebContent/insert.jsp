<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.*, java.util.*" %>

<%
	DAO dao = new DAO();
	int row = dao.custinsert();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
*{margin: 0%;padding: 0%;}

.nav ul,li,a{list-style: none;text-decoration: none; float: left;
padding-left: 15px; padding-bottom: 0 20px; text-align: center;}
.nav{padding: 14px 0px; overflow: hidden; background-color: lightgray}
.subject table{width: 600px; margin: 0 auto; text-align: center;}
.subject table,th,td{border: 1px solid gray; text-align: center;}

.footer{text-align: center; background-color: skyblue; padding: 10px;}

</style>

<script>
	function send() {
		if(frm.custname.value==""){
			alert("이름을 작성해 주세요");
			frm.custname.focus();
			return;
		}
		if(frm.phone.value==""){
			alert("전화번호를 작성해 주세요");
			frm.phone.focus();
			return;
		}
		if(!frm.gender[0].checked && !frm.gender[1].checked){
			alert("성별을 체크해 주세요.");
			return;
			
		}
		if(frm.joindate.value==""){
			alert("가입일자를 작성해 주세요");
			frm.joindate.focus();
			return;
		}
		if(frm.grade.selectedIndex==0){
			alert("고객등급을 선택해 주세요");
			frm.grade.focus();
			return;
		}
		if(frm.city.value==""){
			alert("도시코드를 작성해 주세요");
			frm.city.focus();
			return;
		}
		alert("회원 정보를 등록합니다.");
		frm.submit();
	}
	
	function re() {
		alert("다시 작성 합니다.");
		frm.reset();
		frm.custname.focus();
	}
</script>
</head>
<body>
<div>
	<header>
		<h1 style="text-align: center; padding: 10px" >쇼핑몰 회원관리 ver1.0</h1>
		<nav class="nav">
			<ul class="">
				<li><a href="insert.jsp">회원등록</a></li>
				<li><a href="mlist.jsp"></a>회원목록조회</li>
				<li><a href="cinsert"></a>매출등록</li>
				<li><a href="clist"></a>매출현황조회</li>
				<li><a href="index.jsp">홈으로</a></li>
			</ul>
		</nav>
	</header>
</div>

<div class="subject">
	<section>
		<h2 style="text-align: center;padding: 10px;">회원 정보 등록</h2>
		<form name="frm" action="insert_pro.jsp" method="post">
			<table>
				<tr>
					<td>회원번호(자동발생)</td>
						<th style="text-align: left;">
						<input type="text" name="custno" value="<%=row+1 %>" readonly>
						</th>					
							
				</tr>
				
				<tr>
					<td >회원성명</td>
						<th style="text-align: left;">
						<input type="text" name="custname">
						</th>					
				</tr>
				
				<tr>
					<td >회원전화</td>
						<th style="text-align: left;">
						<input type="text" name="phone">
						</th>					
				</tr>
				
				<tr>
					<td >회원성별</td>
						<th style="text-align: left;">
						<input type="radio" name="gender" value="M">남자
						<input type="radio" name="gender" value="F">여자
						</th>					
				</tr>
				
				<tr>
					<td >가입일자</td>
						<th style="text-align: left;">
						<input type="text" name="joindate">
						</th>					
				</tr>
				
				<tr>
					<td >고객등급</td>
						<th style="text-align: left;">
						<select name="grade">
							<option value="">고객등급</option>
							<option value="A">VIP</option>
							<option value="B">일반</option>
							<option value="C">직원</option>
						</select>
						</th>					
				</tr>
				
				<tr>
					<td >도시코드</td>
						<th style="text-align: left;">
						<input type="text" name="city">
						</th>					
				</tr>
				
				<tr>				
					<th colspan="2">						
						<input type="button" onClick="send()" value="등록하기">
						<input type="button" onClick="re()" value="다시쓰기">
					</th>			
				</tr>
				
				
			</table>		
		</form>
		
	</section>
</div>

<div class="footer";>
	<footer>
		<h3>HRDKOREA dkanakf eowkscl dkanakf eowkscl dkanakf eowkscl dkanakf eowkscl</h3>
	</footer>
</div>


</body>
</html>