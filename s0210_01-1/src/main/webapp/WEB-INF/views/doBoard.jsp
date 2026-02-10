<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>doBoard Page</title>
	</head>
	<body>
		<h2>Board Confirm</h2>
		<h2>bno : ${ board.bno }</h2>
		<h2>title : ${ board.btitle }</h2>
		<h2>content : ${ board.bcontent }</h2>
		<h2>ID : ${ board.id }</h2>
		<ul>
			<li><a href="/">return to Main</a></li>
		</ul>
		
		<%-- 1,2,3
		<h2>Board Confirm</h2>
		<h2>bno : ${ bno }</h2>
		<h2>title : ${ btitle }</h2>
		<h2>content : ${ bcontent }</h2>
		<h2>ID : ${ id }</h2>
		<ul>
			<li><a href="/">return to Main</a></li>
		</ul>
		 --%>
	</body>
</html>