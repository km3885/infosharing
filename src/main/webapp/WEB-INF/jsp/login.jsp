<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ログイン画面テスト</h2>
	<form action="LoginServlet" method="post">
		userID:<input type="text" name="userId"><br>
		pass: <input type="password" name="pass"><br>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>