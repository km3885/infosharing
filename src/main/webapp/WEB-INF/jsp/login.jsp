<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
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
 -->
 
 <!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン画面login</title>
    <link href="https://use.fontawesome.com/releases/v6.2.0/css/all.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/login.css">
<!-- 
<link rel=”stylesheet” type=”text/css” href=”/css/style.css”>
 -->
</head>
<body>
    <header>
        <div class="wrapper">
            <div class="header-left">
              <h1>タイトルタイトルタイトル</h1>
            </div>
            <div class="header-right">
            </div>
          </div>
      
    </header>

    <div class="form-wrapper cf">
        <div class="account-icon">
        </div>
        <form action="LoginServlet" method="post">
            <div class="form-item">
                <label><div class="label-text">ユーザーID</div>
                    <input type="text" name="userId" id="" placeholder="User ID">
                    <i class="fa-solid fa-user"></i>
                </label>
            </div>
            <div class="form-item">
                <label><div class="label-text">パスワード</div>
                    <input type="password" name="pass" id="pass" placeholder="Password">
                    <i class="fa-solid fa-lock"></i>
                </label>
            </div>
            <div class="button-panel">
                <input type="submit" class="button" value="ログイン">
            </div>
        </form>
    </div>

    <footer>

    </footer>

</body>
</html>