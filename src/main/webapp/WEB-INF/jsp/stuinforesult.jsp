

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
				<li class="list"><a href="TopServlet"> <span class="icon">
							<ion-icon name="home-outline"></ion-icon>
					</span> <span class="title">ホーム</span>
				</a></li>
				<li class="list active"><a href="StuinfoServlet"> <span
						class="icon"> <ion-icon name="people-circle-outline"></ion-icon>
					</span> <span class="title">訓練生情報</span>
				</a></li>
				<li class="list"><a href="ManagementServlet"> <span
						class="icon"> <ion-icon name="calendar-outline"></ion-icon>
					</span> <span class="title">イベント管理</span>
				</a></li>
				<li class="list"><a href="AccessInfoServlet"> <span
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

		<!-- contents -->
		<div class="col_2 stu-col2">
			<h2>訓練生情報</h2>

			
			<form action="<%=request.getContextPath()%>/StuinfoServlet" method="post">
				<div class="dd-list">
					<label for="name">名前:</label>
					<select name="stu_name">
						<option>▼選択してください</option>
						<c:forEach var="item" items="${stulist}">
							<option value="${item.no}"><c:out value="${item.name}"></c:out></option>
						</c:forEach>
					</select>
					<button>見る</button>
				</div>
			</form>


<p>結果表示</p>

		</div>

		<div>
			
			
		</div>
	</div>



	<jsp:include page="footer.jsp" />

	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script>
		
	</script>
</body>

</html>