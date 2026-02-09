<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Main Page</title>
	</head>
	<body>
		<h2>Main Page</h2>
		<ul>
			<li><a href="/member/login">로그인</a></li>
			<li><a href="/member/member">아이디전달</a></li>
			<li><a href="/member/membership">회원가입</a></li>
			<li><a href="/member/membershipOk">회원가입확인</a></li>
			<li><a href="/list">게시판</a></li>
			<!-- <li><a href="/member/logout">로그아웃</a></li> -->
		</ul>
	</body>
</html>