<!-- 訓練生情報管理画面 -->

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
				<li class="list active"><a href="StuinfoServlet"> <span
						class="icon"><ion-icon name="walk-outline"></ion-icon> 
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
				<li class="btn-logout"><a href="LogoutServlet" onclick="return confirm('ログアウトしてもよろしいですか？');"> <span
						class="icon"> <ion-icon name="log-out-outline"></ion-icon>
					</span> <span class="title">ログアウト</span>
				</a></li>
			</ul>
		</aside>

		<!-- contents -->
		<div class="col_2 stu-col2">
			<h2>訓練生情報</h2>

			<form action="<%=request.getContextPath()%>/StuinfoServlet"
				method="post">
				<div class="dd-list">
					<label for="name">名前:</label> <select name="stu_name">
						<option>▼選択してください</option>
						<c:forEach var="item" items="${stulist}">
							<option value="${item.no}"><c:out value="${item.name}"></c:out></option>
						</c:forEach>
					</select>
					<button>見る</button>
				</div>
			</form>
			<form action="<%=request.getContextPath()%>/StuinfoServlet"method="get">
				<button type="submit" name="btn" value="new">新規登録</button>
			</form>



			<!-- <form method="post">
        <div>
          <label for="state">状況</label>
          <select name="state">
          <option value="">選択してください</option>
          <option value="">内定</option>
          <option value="">選考中</option>
          <option value="">書類作成中</option>
          <option value="">応募済み</option>
          <option value="">未応募</option>
          </select>
        </div>
      </form> -->
		</div>


		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>no</th>
					<th>name</th>
					<th>state</th>
					<th>co_name</th>
					<th>編集</th>
					<th>削除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${stulist}">
					<tr>
						<td><c:out value="${item.id}" /></td>
						<td><c:out value="${item.no}" /></td>
						<td><c:out value="${item.name}" /></td>
						<td><c:out value="${item.state}" /></td>
						<td><c:out value="${item.coName}" /></td>
						<td><a href="StuinfoServlet?btn=<c:out value="${item.id}" />"><ion-icon
									name="pencil-outline"></ion-icon></a></td>
						<td><a href="StuinfoServlet?trash=<c:out value="${item.id}" />&btn=<c:out value="999" />"><ion-icon
									name="trash-outline"></ion-icon></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

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