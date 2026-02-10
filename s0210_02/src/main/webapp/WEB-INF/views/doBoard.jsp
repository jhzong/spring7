<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판확인 페이지</title>
	</head>
	<body>
		<h2>게시판확인</h2>
		<h2>게시물 번호 : ${ board.bno }</h2>
		<h2>작성자 아이디 : ${ board.id }</h2>
		<h2>게시물 제목 : ${ board.btitle }</h2>
		<h2>게시물 내용 : ${ board.bcontent }</h2>
		<ul>
			<li><a href="/">메인으로</a></li>
		</ul>
	</body>
</html>