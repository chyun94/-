<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*,java.util.*" %>
<%
DAO d = new DAO();
int row = d.custinsert();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{margin: 0px; padding: 0px;}

.nav ul,li,a{text-align: center; list-style: none; text-decoration: none; float:left;
padding-left: 15px; padding-bottom: 0 20px; }
.nav {overflow: hidden; background-color: lightgray; padding: 14px 0px;}
.subject table{width: 600px; margin: 0 auto;}
.subject table,th,td{border: 1px solid gray; text-align: center;}

.footer{text-align: center; background-color: skyblue; padding: 10px;}
</style>

<script>
	function sen() {
		if(bin.info.value==""){
			alert("이름 안써졌어요");
			bin.info.focus();
			return;
		}if(!bin.gender[0].checked && !bin.gender[1].checked){
			alert("성별 선택해줘요");
			return;
		}if(bin.grade.selectedIndex==0){
			alert("고객등급 선택해줘요");
			bin.grade.focus();
			return;
		}
		alert("등록 할게요");
		bin.submit();
	}
	
	function rew() {
		alert("다시 등록 할게요"	);
		bin.reset();
		bin.custname.focus();
		
	}
</script>
</head>
<body>
<div>
	<header>
		<h1 style="text-align: center;"> 쇼핑몰 회원관리 시스템 ver21.0405</h1>
		<nav class="nav">
			<ul>
				<li><a href="insert2.jsp">회원등록</a>
				<li><a href="#">회원등록</a>
				<li><a href="#">회원등록</a>
				<li><a href="#">회원등록</a>
				<li><a href="index.jsp">홈으로</a>
			</ul>
		</nav>
	</header>
</div>
	
<div class="subject">
	<section>
		<h2 style="text-align: center;padding: 10px;">회원 정보 등록</h2>
		<form action="insert2_pro.jsp" method="post" name="bin">
			<table>
				<tr>
					<td>회원번호(자동발생)</td>
					<th style="text-align: left;">
					<input type="text" value="<%=row+1 %>" name="custno">
					</th>					
				</tr>
				  
				<tr>
					<td>회원이름</td>
					<th style="text-align: left;">
					<input type="text" value="" name="info">
					</th>					
				</tr>
				
				<tr>
					<td>성별</td>
					<th style="text-align: left;">
					<input type="radio" value="M" name="gender">남
					<input type="radio" value="F" name="gender">여
					</th>					
				</tr>
				
				<tr>
					<td>고객등급</td>
					<th style="text-align: left;">
					<select name="grade">
						<option value="">고갱등급</option>
						<option value="A">VIP</option>
						<option value="B">일반</option>
						<option value="C">직원</option>
					</select>
					</th>					
				</tr>
				
				<tr>
					<th colspan="2">
						<input type="button" onclick="sen()" value="등록하기">
						<input type="button" onclick="rew()" value="다시쓰기">
					</th>
				</tr>
				
			</table>
		</form>
	</section>
</div>

<div class="footer">
	<footer>
		<h3>HRDKOREA WE CAN DO ANITHING GREEN AIRY BAMBOO SOFT SOAP</h3>
	</footer>
</div>
</body>
</html>