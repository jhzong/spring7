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
		<script type="text/javascript">
			if("${flag}"==1){
				alert("로그인됨")
			}
		</script>
	</head>
	<body>
		<h2>Main Page</h2>
		<ul>
			<li><a href="/mUpdate">회원정보 수정</a></li>
			<li><a href="/login">login</a></li>
			<li><a href="/join">join</a></li>
			<li><a href="/board">board</a></li>
			<li><a href="/boardView/1">1번 게시글</a></li>
			<%--
			 --%>
		</ul>
		
		<p>${ now }</p>
		<p><fmt:formatDate value="${now}" pattern="YYYY-MM-dd HH:mm:ss"/></p>
		<p><fmt:formatNumber value="3.141592" pattern="000.##"></fmt:formatNumber></p>
	</body>
</html>