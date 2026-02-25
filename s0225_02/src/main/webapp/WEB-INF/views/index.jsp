<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인 페이지</title>
		<script type="text/javascript">
			function logoutBtn(){
				alert("로그아웃합니다.");
				location.href="/member/logout";
			}
		</script>
		<style type="text/css">
		a{cursor: pointer; text-decoration: none;}
		</style>
	</head>
	<body>
		<h2>메인 페이지</h2>
			<ul>
			<c:if test="${session_id==null}">
				<h3>로그인을 해야합니다.</h3>
				<li><a href="/member/login">로그인</a></li>
				<li><a href="/member/join">회원가입</a></li>
			</c:if>
			<c:if test="${session_id!=null}">
				<h3>${session_name}님 환영합니다.</h3>
				<li><a onclick="logoutBtn()">로그아웃</a></li>
				<li><a href="/member/mlist">회원전체리스트</a></li>
			</c:if>
			</ul>
	</body>
</html>