<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ログイン画面login</title>
<link href="https://use.fontawesome.com/releases/v6.2.0/css/all.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/login.css">


</head>
<body>
	<div class="container">
		<header>
			<div class="wrapper">
				<div class="header-left">
					<h1>就職活動情報共有ツール</h1>
				</div>
				<div class="header-right"></div>
			</div>

		</header>

		<p style="color: red;">
			<ion-icon name="warning-outline"></ion-icon>
			ユーザIDまたはパスワードが正しくありません。
		</p>
		<div class="form-wrapper cf">
			<div class="account-icon"></div>
			<form action="LoginServlet" method="post">
				<div class="form-item">
					<label>ユーザーID <input type="text" name="userId" id=""
						placeholder="User ID"> <i class="fa-solid fa-user"></i>
					</label>
				</div>
				<div class="form-item">
					<label>パスワード <input type="password" name="pass" id="pass"
						placeholder="Password"> <i class="fa-solid fa-lock"></i>
					</label>
				</div>
				<div class="button-panel">
					<input type="submit" class="button" value="ログイン">
				</div>
			</form>
		</div>

		<jsp:include page="footer.jsp" />
	</div>

	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>
</html>