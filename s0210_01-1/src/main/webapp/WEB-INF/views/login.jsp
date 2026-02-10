<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Page</title>
		<script type="text/javascript">
			if("${flag}"==2){
				alert("아이디 또는 비번 불일치")
			}
		</script>
	</head>
	<body>
		<h2>Login</h2>
		<form action="/doLogin" method="post" name="frm">
			<input type="text" name="id" placeholder="type ID"><br>
			<input type="text" name="pw" placeholder="type PW"><br>
			<input type="submit" value="LOGIN">
		</form>
		<a href="/">return to Main</a>
	</body>
</html>