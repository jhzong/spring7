<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>doLogin Page</title>
	</head>
	<body>
		<h2>Login Confirm</h2>
		<h2>ID : ${ id }</h2>
		<h2>PW : ${ pw }</h2>
		<a href="/">return to Main</a>
	</body>
</html>