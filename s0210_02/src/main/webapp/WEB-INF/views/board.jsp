<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판 페이지</title>
	</head>
	<body>
		<h2>게시판</h2>
		<form action="/board" method="post">
			<label>게시물 번호</label>
			<input type="text" name="bno" placeholder="type no"><br>
			<label>작성자 아이디</label>
			<input type="text" name="id" placeholder="type ID"><br>
			<label>게시물 제목</label>
			<input type="text" name="btitle" placeholder="type title"><br>
			<label>게시물 내용</label>
			<input type="text" name="bcontent" placeholder="type content"><br>
			
			<input type="submit" value="등록하기">
		</form>
		<ul>
			<li><a href="/">메인으로</a></li>
		</ul>
	</body>
</html>