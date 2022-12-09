<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/style.css">
<title>訓練生情報2</title>

<script type="text/javascript"> 

function check(){

	if(window.confirm( ${stu1.no} + '\n送信してよろしいですか？')){ // 確認ダイアログを表示

		return true; // 「OK」時は送信を実行

	}
	else{ // 「キャンセル」時の処理

		window.alert('キャンセルされました'); // 警告ダイアログを表示
		return false; // 送信を中止

	}

}

</script>
</head>

<body>
	<!-- header -->
	<jsp:include page="header.jsp" />

	<div class="col">
		<!-- サイドメニュー -->
		<aside class="navigation">
			<ul>
				<li class="list"><a href="TopServlet"> <span class="icon">
							<ion-icon name="home-outline"></ion-icon>
					</span> <span class="title">ホーム</span>
				</a></li>
				<li class="list"><a href="StuinfoServlet"> <span
						class="icon"> <ion-icon name="people-circle-outline"></ion-icon>
					</span> <span class="title">訓練生情報</span>
				</a></li>
				<li class="list"><a href="EventInfoServlet"> <span
						class="icon"> <ion-icon name="calendar-outline"></ion-icon>
					</span> <span class="title">イベント管理</span>
				</a></li>
				<li class="list active"><a href="AccessInfoServlet"> <span
						class="icon"> <ion-icon name="shield-checkmark-outline"></ion-icon>
					</span> <span class="title">アクセス権限</span>
				</a></li>
				<li class="btn-logout"><a href="LogoutServlet"
					onclick="return confirm('ログアウトしてもよろしいですか？');"> <span
						class="icon"> <ion-icon name="log-out-outline"></ion-icon>
					</span> <span class="title">ログアウト</span>
				</a></li>
			</ul>
		</aside>

		<!-- コンテンツ -->
		<div class="col_2 stu-col2">
			<h2>訓練生情報管理</h2>
			Edit画面
			
			<form action="StuinfoServlet" method="post" onSubmit="return check()">
				<p><label>ID <input type="text" name="id" value="${stu1.id}"></label></p>
				<p><label>番号 <input type="text" name="no" value="${stu1.no}"></label></p>
				<p><label>名前 <input type="text" name="name" value="${stu1.name}"></label></p>
				<p><label>就活状況
					<select name="state">
						<c:forEach var="item" items="${selectlist}">
							<c:choose>
								<c:when test="${item == stu1.state}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select>
				</label></p>
				<p><label>企業名 <input type="text" name="coName" value="${stu1.coName}"></label></p>
				<p><button type="submit" name="btn" value="new">登録</button></p>
			</form>
			
		</div>
	</div>



	<jsp:include page="footer.jsp" />

	<!-- <script src="js/main.js"></script> -->

	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

	
</body>

</html>