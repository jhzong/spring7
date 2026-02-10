<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>doJoin Page</title>
	</head>
	<body>
		<h2>Join Confirm</h2>
		<h2>ID : ${ id }</h2>
		<h2>PW : ${ pw }</h2>
		<h2>name : ${ name }</h2>
		<h2>phone : ${ phone }</h2>
		<h2>email : ${ email }</h2>
		<h2>gender : ${ gender }</h2>
		<h2>hobby : 
		<c:forEach var="h" items="${hobby}" varStatus="s">
			${h}<c:if test="${!s.last}">, </c:if>
		</c:forEach>
		</h2>
		<a href="/">return to Main</a>
	</body>
</html>