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
*{margin: 0%; padding: 0%;}

.nav ul,li,a{text-align: center; text-decoration: none; float: left;
padding-left: 15px; padding-bottom: 0 20px; list-style: none;}
.nav{padding: 14px 0px; overflow: hidden; background-color: lightgray;}

.subject table{width: 600px; margin: 0 auto; padding-left: 10px;}
.subject table,th,td{border: 1px solid gray;}

.footer{text-align: center;background-color: skyblue; padding: 10px;}
</style>

<script>
function send() {
	if(frm.custname.value==""){
		alert("이름 안써졌으니 확인~");
		frm.custname.focus();
		return;
	}
	alert("회원 등록할게~");
	frm.submit();
}
function re() {
	alert("다시작성합니다");
	grm.reset();
	frm.custname().focus();
}
</script>

</head>
<div>
	<header>
		<h1 style="text-align: center; padding: 10px;">이건 큰 제목</h1>
		<nav class="nav">
			<ul>
				<li><a href="#">이응</a></li>
				<li><a href="#">이응</a></li>
				<li><a href="#">이응</a></li>
				<li><a href="#">이응</a></li>
				<li><a href="#">이응</a></li>
			</ul>
		</nav>
	</header>
</div>

<div class="subject">
	<section>
		<h2 style="text-align: center;">이건 가운데로 가는 중간 제목</h2>
		<form action="insert_pro2" method="post" name="frm">
			<table>
				<tr>
					<td>회원번호(자동발생)</td>
					<th style="text-align: left;">
					<input type="text" name="custno" value="<%=row+1%>" readonly>
					</th>
				</tr>
				
				<tr>
					<td>회원이름</td>
					<th style="text-align: left;">
					<input type="text" name="custname">
					</th>
				</tr>
				
				<tr>
					<th colspan="2">
					<input type="button" onclick="send()" value="등록">
					<input type="button" onclick="re()" value="다시쓰기">				
					</th>
				</tr>
				
			</table>
		</form>
	</section>
</div>

<div class="footer">
	<footer>
		<h3>이 글씨는 가운데로 가겠지?</h3>
	</footer>
</div>
</html>