<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
<style>
img {
	max-width: 100%;
}

body {
	position: relative;
	margin-top: 100px;
	display: flex;
	align-items: center;
	justify-content: center
}

form {
 	border : 2px solid red;
	width: 40%;
	border-radius : 5px;
	position: relative;
	lef: 50%
}

.xep-phong {
	background-color: #198754;
	color : white;
	border : none;
	outline : none;
	padding: 5px
}

</style>
</head>
<body>
	<%
		session.setAttribute("gv", null);
		session.setAttribute("pt", null);
		session.setAttribute("ca", null);
		session.setAttribute("dspc", null);
		session.setAttribute("dsgs", null);
	%>
	<form name="f1" action="xulifile" method="post"
		enctype="multipart/form-data">
		<h2 align="center">Xếp cán bộ coi thi</h2>
		<p align="center">
			Số ca thi: <input type="text" name="ca">
		<p align="center">
			Danh sách giảng viên: <input type="file" name="gv">
		<p align="center">
			Danh sách phòng thi: <input type="file" name="pt">
		<p align="center">
			<input class="xep-phong" type="submit" value="Xếp phòng">
	</form>
</body>
</html>