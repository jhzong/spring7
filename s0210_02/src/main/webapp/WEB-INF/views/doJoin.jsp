<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>가입확인 페이지</title>
	</head>
	<body>
		<h2>가입확인</h2>
		<h2>아이디 : ${ member.id }</h2>
		<h2>패스워드 : ${ member.pw }</h2>
		<h2>이름 : ${ member.name }</h2>
		<h2>전화번호 : ${ member.phone }</h2>
		<h2>이메일 : ${ member.email }</h2>
		<h2>성별 : ${ member.gender }</h2>
		<h2>취미 : 
		<c:forEach var="h" items="${member.hobby}" varStatus="s">
			${h}<c:if test="${!s.last}">, </c:if>
		</c:forEach>
		</h2>
		<ul>
			<li><a href="/">메인으로</a></li>
		</ul>
	</body>
</html>