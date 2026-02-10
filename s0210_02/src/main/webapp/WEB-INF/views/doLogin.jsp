<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인확인 페이지</title>
	</head>
	<body>
		<h2>로그인확인</h2>
		<h2>아이디 : ${ member.id }</h2>
		<h2>패스워드 : ${ member.pw }</h2>
		<ul>
			<li><a href="/">메인으로</a></li>
		</ul>
	</body>
</html>