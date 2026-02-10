<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보 수정</title>
	</head>
	<body>
		<h2>회원정보 수정</h2>
		<form action="/doJoin" method="post">
			<label>ID</label>
			<input type="text" name="id" value="${member.id}" placeholder="type ID"><br>
			<label>PW</label>
			<input type="text" name="pw" value="${member.pw}" placeholder="type PW"><br>
			<label>name</label>
			<input type="text" name="name" value="${member.name}" placeholder="type name"><br>
			<label>phone</label>
			<input type="text" name="phone" value="${member.phone}" placeholder="type phone"><br>
			<label>email</label>
			<input type="text" name="email" value="${member.email}" placeholder="type email"><br>
			
			<label>gender</label><br>
			<input type="radio" id="male" name="gender" value="남자"
			<c:if test="${fn:contains(member.gender, '남자')}">checked</c:if>>
			<label for="남자">남자</label>
			<input type="radio" id="female" name="gender" value="여자"
			<c:if test="${fn:contains(member.gender, '여자')}">checked</c:if>>
			<label for="여자">여자</label><br>
			
			<label>hobby</label><br>
			<input type="checkbox" name="hobby" value="게임"
			<c:if test="${fn:contains(member.hobby, '게임')}">checked</c:if>>
			<label for="게임">게임</label>
			<input type="checkbox" name="hobby" value="골프"
			<c:if test="${fn:contains(member.hobby, '골프')}">checked</c:if>>
			<label for="골프">골프</label>
			<input type="checkbox" name="hobby" value="수영"
			<c:if test="${fn:contains(member.hobby, '수영')}">checked</c:if>>
			<label for="수영">수영</label>
			<input type="checkbox" name="hobby" value="조깅"
			<c:if test="${fn:contains(member.hobby, '조깅')}">checked</c:if>>
			<label for="조깅">조깅</label>
			<input type="checkbox" name="hobby" value="독서"
			<c:if test="${fn:contains(member.hobby, '독서')}">checked</c:if>>
			<label for="독서">독서</label>
			
			<input type="submit" value="JOIN">
		</form>
		<a href="/">return to Main</a>
	</body>
</html>