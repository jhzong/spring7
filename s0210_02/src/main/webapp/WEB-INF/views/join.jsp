<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입 페이지</title>
	</head>
	<body>
		<h2>회원가입</h2>
		<form action="/doJoin" method="post">
			<label>아이디</label>
			<input type="text" name="id" placeholder="type ID"><br>
			<label>패스워드</label>
			<input type="text" name="pw" placeholder="type PW"><br>
			<label>이름</label>
			<input type="text" name="name" placeholder="type name"><br>
			<label>전화번호</label>
			<input type="text" name="phone" placeholder="type phone"><br>
			<label>이메일</label>
			<input type="text" name="email" placeholder="type email"><br>
			
			<label>성별</label><br>
			<input type="radio" id="male" name="gender" value="male">
			<label for="male">남자</label>
			<input type="radio" id="female" name="gender" value="female">
			<label for="female">여자</label><br>
			
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
			<label for="독서">독서</label>
			
			<input type="submit" value="가입완료">
		</form>
		<ul>
			<li><a href="/">메인으로</a></li>
		</ul>
	</body>
</html>