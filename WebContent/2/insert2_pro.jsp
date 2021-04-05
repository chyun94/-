<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*,java.util.*" %>
<%
request.setCharacterEncoding("utf-8");
DAO d = new DAO();
VO v = new VO();
v.setCustno(Integer.parseInt(request.getParameter("custno")));
v.setCustname(request.getParameter("custname"));
v.setGender(request.getParameter("gender"));
v.setCity(request.getParameter("city"));
d.insert(v);
%>
<script>
	alert("회원 정보 등록 했어요~");
	location.herf="2/index2.jsp";
</script>