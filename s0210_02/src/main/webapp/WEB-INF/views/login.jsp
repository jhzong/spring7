<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 페이지</title>
	</head>
	<body>
		<h2>로그인</h2>
		<form action="/login" method="post">
			<label>아이디</label>
			<input type="text" name="id" placeholder="type ID"><br>
			<label>패스워드</label>
			<input type="text" name="pw" placeholder="type PW"><br>
			<input type="submit" value="로그인">
		</form>
		<ul>
			<li><a href="/">메인으로</a></li>
		</ul>
	</body>
</html>