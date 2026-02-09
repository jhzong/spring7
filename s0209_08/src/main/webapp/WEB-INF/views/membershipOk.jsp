<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>membershipOk</title>
	</head>
	<body>
		<h2>membershipOk-POST</h2>
		<h3>아이디 : ${id}</h3>
		<h3>패스워드 : ${pw}</h3>
		<h3>이름 : ${name}</h3>
		<h3>전화번호 : ${phone}</h3>
		<h3>이메일 : ${email}</h3>
		<h3>성별 : ${gender}</h3>
		<h3>취미 : 
		<c:forEach var="h" items="${hobby}" varStatus="s">
			${h}<c:if test="${!s.last}">, </c:if>
		</c:forEach>
		</h3>
		<a href="/">홈으로</a>
	</body>
</html>