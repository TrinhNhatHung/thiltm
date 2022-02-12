<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kết quả</title>
</head>
<style>
body {
	position: relative;
	margin-top: 100px;
	display: flex;
	align-items: center;
	justify-content: center
}

.content {
 	border : 2px solid red;
	width: 40%;
	border-radius : 5px;
	position: relative;
	lef: 50%
}

.btn {
	background-color: #198754;
	color : white;
	border : none;
	outline : none;
	padding: 5px
}

.btn-primary {
	background-color: #0D6EFD;
	color : white;
	border : none;
	outline : none;
	padding: 5px
}

</style>
<body>
	<%
		if (session.getAttribute("dspc") != null && session.getAttribute("dsgs") != null) {
	%>
	<div class="content">
		<h2 align="center">Đã tạo lịch thi thành công!</h2>
		<form name="f2" action="phancong" method="post">
			<p align="center">
				<input class="btn" type="submit" value="Download DS phân công!">
		</form>
		<form name="f3" action="giamsat" method="post">
			<p align="center">
				<input class="btn" type="submit" value="Download DS giám sát!">
		</form>
		<form name="f1" action="index.jsp" method="post">
			<p align="center">
				<input class="btn-primary" type="submit" value="Trang chủ">
		</form>
	</div>
	<%
		} else {
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", "index.jsp");
		}
	%>
</body>
</html>