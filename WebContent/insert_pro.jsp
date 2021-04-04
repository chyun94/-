<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*,java.util.*"%>

<%
	request.setCharacterEncoding("utf-8");
DAO d = new DAO();
VO v = new VO();

v.setCustno(Integer.parseInt(request.getParameter("custno")));
v.setCustname(request.getParameter("custname"));
v.setPhone(request.getParameter("phone"));
v.setGender(request.getParameter("gender"));
v.setJoindate(request.getParameter("joindate"));
v.setGrade(request.getParameter("grade"));
v.setCity(request.getParameter("city"));

d.insert(v);
%>

<script>
	alert("회원 정보가 등록되었습니다.");
	location.href = "index.jsp";
</script>