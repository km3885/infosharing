<!-- 訓練生情報削除画面 -->

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
<link rel="stylesheet" href="./css/stuinfo.css">
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
				<li class="list active"><a href="StuinfoServlet?btn=normal">
						<span class="icon"><ion-icon name="walk-outline"></ion-icon>
					</span> <span class="title">就活状況管理</span>
				</a></li>
				<li class="list"><a href="ManagementServlet"> <span
						class="icon"> <ion-icon name="people-circle-outline"></ion-icon>
					</span> <span class="title">訓練生情報管理</span>
				</a></li>
				<li class="list"><a href="AccessInfoServlet"> <span
						class="icon"> <ion-icon name="shield-checkmark-outline"></ion-icon>
					</span> <span class="title">アクセス権限管理</span>
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

			
			<form action="StuinfoServlet?hoge=bar" method="post" onSubmit="return check()" class=".form-wrapper">
				

			<form action="StuinfoServlet?hoge=bar" method="post"
				onSubmit="return check()">


				<table>
					<tbody>
						<tr>
							<th>ID</th>
							<td><input type="hidden" name="id" value="${trashStu.id}">
							<c:out value="${trashStu.id}" /></td>
						</tr>
						<tr>
							<th>番号</th>
							<td><input type="hidden" name="no" value="${trashStu.no}">
							<c:out value="${trashStu.no}" /></td>
						</tr>
						<tr>
							<th>名前</th>
							<td><input type="hidden" name="name"
								value="${trashStu.name}">
							<c:out value="${trashStu.name}" /></td>
						</tr>
						<tr>
							<th>就活状況</th>
							<td><input type="hidden" name="state"
								value="${trashStu.state}">
							<c:out value="${trashStu.state}" /></td>
						</tr>
						<tr>
							<th>企業名</th>
							<td><input type="hidden" name="coName"
								value="${trashStu.coName}">
							<c:out value="${trashStu.coName}" /></td>
						</tr>
					</tbody>
				</table>
				<p>
					<button type="submit" name="btn" value="delete">削除</button>
				</p>
			</form>

			<!-- 就活状況管理へ戻る -->
			<form action="StuinfoServlet" method="get">
				<p>
					<button type="submit" name="btn" value="normal">戻る</button>
				</p>
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