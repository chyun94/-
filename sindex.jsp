<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Study</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<style>
* {
	margin: 0%;
	padding: 0%;
}

.nav ul, li, a {
	opacity: 0.7;
	list-style: none;
	text-decoration: none;
	float: left;
	padding-left: 15px;
	padding-bottom: 0 20px;
	text-align: center;
	list-style: none;
}

.nav {
	padding: 14px 0px;
	overflow: hidden;
	background: lightblue;
}

.h1 {
	text-align: center;
	font-size: large;
	background-color: orange;
	opacity: 0.5;
	border: 1px solid orange;
	padding-bottom: 5px;
}

.subject table {
	width: 600px;
	height: 600px;
	margin: 0 auto;
}

.subject table, th, td {
	border: 1px solid gray;
}

.footer {
	text-align: center;
	background: lightgray;
	font-size: medium;
	opacity: 0.5;
}
</style>
</head>
<body>
	<div class="h1" align="center">
		<h1>Study</h1>
	</div>
	<header>
		<div>
			<nav class="nav">
				<ul>
					<li><a href="Codig.jsp">Coding</a></li>
					<li><a href="Nihongo.jsp">日本語</a></li>
					<li><a href="join.jsp">회원가입</a></li>
				</ul>
			</nav>
		</div>
	</header>

	<section>
		<div class="jumbotron jumbotron-fluid">
			<div class="container" style="margin-bottom: 0px;">
				<h1 class="display-4">Main</h1>
				<p class="lead">오늘은 부트스트랩 적용과 Background배경을 투명도 설적 하는 것을 복습 했다. 20210506</p>
			</div>
		</div>
	</section>

	<footer>
		<div class="footer">
			<p1> Coding,日本語_000.ver20210506 HellChosun in Survival</p1>
		</div>
	</footer>

</body>
</html>