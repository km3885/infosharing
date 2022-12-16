<!-- アクセス権限編集画面 -->

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
<title>訓練生情報</title>
</head>

<body>
	<!-- header -->
	<jsp:include page="header.jsp" />

	<div class="col">
		<!-- サイドメニュー -->
		<aside class="navigation">
			<ul>
				<li class="list"><a href="TopServlet"> <span
						class="icon"> <ion-icon name="home-outline"></ion-icon>
					</span> <span class="title">ホーム</span>
				</a></li>
				<li class="list"><a href="StuinfoServlet?btn=normal"> <span
						class="icon"><ion-icon name="walk-outline"></ion-icon> 
					</span> <span class="title">就活状況管理</span>
				</a></li>
				<li class="list"><a href="ManagementServlet"> <span
						class="icon"> <ion-icon name="people-circle-outline"></ion-icon>
					</span> <span class="title">訓練生情報管理</span>
				</a></li>
				<li class="list active"><a href="AccessInfoServlet"> <span
						class="icon"> <ion-icon name="shield-checkmark-outline"></ion-icon>
					</span> <span class="title">アクセス権限管理</span>
				</a></li>
				<li class="btn-logout"><a href="LogoutServlet" onclick="return confirm('ログアウトしてもよろしいですか？');"> <span
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
				</thead>
				<tbody>
				<c:forEach var="item" items="${userlist}">
				<c:if test="${item.role == true}" var="flg"></c:if>
				<c:choose>
					<c:when test="${flg}">
						<c:set var="result" value="〇"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="result" value=""></c:set>
					</c:otherwise>
				</c:choose>
					<tr>
						<td><c:out value="${item.userName}" /></td>
						<td><c:out value="${item.loginId}" /></td>
						<td><c:out value="〇" /></td>
						<td><c:out value="${result}" /></td>
						<td><c:out value="${result}" /></td>
						<td><c:out value="${result}" /></td>
						<td><a href="AccessInfoServlet?id=<c:out value="${item.loginId}" />"><ion-icon name="pencil-outline"></ion-icon></a></td>
						<td><ion-icon name="trash-outline"></ion-icon></td>
					</tr>
				</c:forEach>
				</tbody>
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