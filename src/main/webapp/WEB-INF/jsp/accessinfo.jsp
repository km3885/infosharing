<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/style.css">
<title>訓練生情報</title>
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
			<h2>アクセス権限管理</h2>

			<table class="user-table">
				<thead>
					<tr>
						<th>ユーザ名</th>
						<th>ユーザID</th>
						<th>参照</th>
						<th>登録</th>
						<th>更新</th>
						<th>削除</th>
						<th></th>
						<th></th>
					</tr>
					<tr>
						<td>沖縄 太郎</td>
						<td>user1</td>
						<td>〇</td>
						<td>〇</td>
						<td>〇</td>
						<td>〇</td>
						<td><ion-icon name="pencil-outline"></ion-icon></td>
						<td><ion-icon name="trash-outline"></ion-icon></td>
					</tr>
					<tr>
						<td>福岡 一悟</td>
						<td>user2</td>
						<td>〇</td>
						<td>〇</td>
						<td>〇</td>
						<td>〇</td>
						<td><ion-icon name="pencil-outline"></ion-icon></td>
						<td><ion-icon name="trash-outline"></ion-icon></td>
					</tr>
					<tr>
						<td>斎藤 健太</td>
						<td>user3</td>
						<td>〇</td>
						<td>〇</td>
						<td>〇</td>
						<td>〇</td>
						<td><ion-icon name="pencil-outline"></ion-icon></td>
						<td><ion-icon name="trash-outline"></ion-icon></td>
					</tr>
					<tr>
						<td>高橋 空</td>
						<td>user4</td>
						<td>〇</td>
						<td></td>
						<td></td>
						<td></td>
						<td><ion-icon name="pencil-outline"></ion-icon></td>
						<td><ion-icon name="trash-outline"></ion-icon></td>
					</tr>
					<tr>
						<td>護得久 紗良</td>
						<td>user5</td>
						<td>〇</td>
						<td></td>
						<td></td>
						<td></td>
						<td><ion-icon name="pencil-outline"></ion-icon></td>
						<td><ion-icon name="trash-outline"></ion-icon></td>
					</tr>
				</thead>
			</table>


		</div>
	</div>



	<jsp:include page="footer.jsp" />

	<!-- <script src="js/main.js"></script> -->

	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script>
		
	</script>
</body>

</html>