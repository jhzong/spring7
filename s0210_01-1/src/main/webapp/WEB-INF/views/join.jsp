<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Join Page</title>
	</head>
	<body>
		<h2>Join</h2>
		<form action="/doJoin" method="post">
			<label>ID</label>
			<input type="text" name="id" placeholder="type ID"><br>
			<label>PW</label>
			<input type="text" name="pw" placeholder="type PW"><br>
			<label>name</label>
			<input type="text" name="name" placeholder="type name"><br>
			<label>phone</label>
			<input type="text" name="phone" placeholder="type phone"><br>
			<label>email</label>
			<input type="text" name="email" placeholder="type email"><br>
			
			<label>gender</label><br>
			<input type="radio" id="male" name="gender" value="male">
			<label for="male">male</label>
			<input type="radio" id="female" name="gender" value="female">
			<label for="female">female</label><br>
			
			<label>hobby</label><br>
			<input type="checkbox" name="hobby" value="game">
			<label for="game">game</label>
			<input type="checkbox" name="hobby" value="golf">
			<label for="golf">golf</label>
			<input type="checkbox" name="hobby" value="swim">
			<label for="swim">swim</label>
			<input type="checkbox" name="hobby" value="running">
			<label for="running">running</label>
			<input type="checkbox" name="hobby" value="reading">
			<label for="reading">reading</label>
			
			<input type="submit" value="JOIN">
		</form>
		<a href="/">return to Main</a>
	</body>
</html>