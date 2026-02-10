<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Join Page</title>
	</head>
	<body>
		<h2>Board</h2>
		<form action="/board" method="post">
			<label>no</label>
			<input type="text" name="bno" placeholder="type no"><br>
			<label>ID</label>
			<input type="text" name="id" placeholder="type ID"><br>
			<label>title</label>
			<input type="text" name="btitle" placeholder="type title"><br>
			<label>content</label>
			<input type="text" name="bcontent" placeholder="type content"><br>
			
			<input type="submit" value="SUBMIT">
		</form>
		<a href="/">return to Main</a>
	</body>
</html>