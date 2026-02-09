<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
	<body>
		<h2>회원가입</h2>
		<form action="/member/membershipOk" method="post" name="frm">
			<input type="text" name="name" placeholder="이름 입력"><br>
			<input type="text" name="id" placeholder="아이디 입력"><br>
			<input type="text" name="pw" placeholder="패스워드 입력"><br>
			<input type="text" name="phone" placeholder="전화번호 입력"><br>
			<input type="text" name="email" placeholder="이메일 입력"><br>
			
			<label>성별</label><br>
			<input type="radio" name="gender" value="남자">
			<label for="남자">남자</label>
			<input type="radio" name="gender" value="여자">
			<label for="여자">여자</label><br>
			
			<label>취미</label><br>
			<input type="checkbox" name="hobby" value="게임">
			<label for="게임">게임</label>
			<input type="checkbox" name="hobby" value="골프">
			<label for="골프">골프</label>
			<input type="checkbox" name="hobby" value="수영">
			<label for="수영">수영</label>
			<input type="checkbox" name="hobby" value="조깅">
			<label for="조깅">조깅</label>
			<input type="checkbox" name="hobby" value="독서">
			<label for="독서">독서</label><br>
			
			<input type="submit" value="회원가입">
		</form>
	</body>
</html>