<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<h2>Login</h2>
		<form action="/member/loginOk" method="post" name="frm">
			<input type="text" name="id" placeholder="아이디 입력"><br>
			<input type="text" name="pw" placeholder="패스워드 입력"><br>
			<input type="submit" value="로그인">
		</form>
	</body>
</html>