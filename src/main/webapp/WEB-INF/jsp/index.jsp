<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/common.css">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/styleadmin.css">
<title>訓練生情報</title>
</head>

<body>
	<!-- header -->
	<jsp:include page="header.jsp" />


	<div class="col">
		<!-- サイドメニュー -->
		<aside class="navigation">
			<ul>
				<li class="list active"><a href="TopServlet"> <span
						class="icon"> <ion-icon name="home-outline"></ion-icon>
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
				<li class="list"><a href="AccessInfoServlet"> <span
						class="icon"> <ion-icon name="shield-checkmark-outline"></ion-icon>
					</span> <span class="title">アクセス権限</span>
				</a></li>
				<li class="btn-logout"><a href="LogoutServlet" onclick="return confirm('本当にログアウトしてもよろしいですか？');"> <span
						class="icon"> <ion-icon name="log-out-outline"></ion-icon>
					</span> <span class="title">ログアウト</span>
				</a></li>
			</ul>
		</aside>

		<!-- コンテンツ -->
		<!-- メイン -->
		<article class="main">
			<h1>就職活動状況</h1>
			
			<!-- 
			<div class="tab-wrap">
			 -->
			<form action="StuinfoServlet" method="get" class="tab-wrap">
				<!-- 内定 -->
				<input id="TAB02-01" type="radio" name="TAB02" class="tab-switch"
					checked="checked" /><label class="tab-label" for="TAB02-01">内定</label>
				<div class="tab-content">
					<table>
						<tbody>
							<tr>
								<th>番号</th>
								<th>名前</th>
								<th>企業名</th>
							</tr>
							<c:forEach var="item" items="${stulist}">
								<c:if test="${item.state == '内定'}" var="flg"></c:if>
								<c:if test="${flg}">
									<tr>
										<td><c:out value="${item.no}"></c:out></td>
										<td><c:out value="${item.name}"></c:out></td>
										<td><c:out value="${item.state}"></c:out></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- 選考中 -->
				<input id="TAB02-02" type="radio" name="TAB02" class="tab-switch" /><label
					class="tab-label" for="TAB02-02">選考中</label>
				<div class="tab-content">
					<table>
						<tbody>
							<tr>
								<th>番号</th>
								<th>名前</th>
								<th>企業名</th>
							</tr>
							<c:forEach var="item" items="${stulist}">
								<c:if test="${item.state == '選考中'}" var="flg"></c:if>
								<c:if test="${flg}">
									<tr>
										<td><c:out value="${item.no}"></c:out></td>
										<td><c:out value="${item.name}"></c:out></td>
										<td><c:out value="${item.state}"></c:out></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- 書類作成中 -->
				<input id="TAB02-03" type="radio" name="TAB02" class="tab-switch" /><label
					class="tab-label" for="TAB02-03">書類作成中</label>
				<div class="tab-content">
					<table>
						<tbody>
							<tr>
								<th>番号</th>
								<th>名前</th>
								<th>企業名</th>
							</tr>
							<c:forEach var="item" items="${stulist}">
								<c:if test="${item.state == '書類作成中'}" var="flg"></c:if>
								<c:if test="${flg}">
									<tr>
										<td><c:out value="${item.no}"></c:out></td>
										<td><c:out value="${item.name}"></c:out></td>
										<td><c:out value="${item.state}"></c:out></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- 応募済み -->
				<input id="TAB02-04" type="radio" name="TAB02" class="tab-switch" /><label
					class="tab-label" for="TAB02-04">応募済み</label>
				<div class="tab-content">
					<table>
						<tbody>
							<tr>
								<th>番号</th>
								<th>名前</th>
								<th>企業名</th>
							</tr>
							<c:forEach var="item" items="${stulist}">
								<c:if test="${item.state == '応募済み'}" var="flg"></c:if>
								<c:if test="${flg}">
									<tr>
										<td><c:out value="${item.no}"></c:out></td>
										<td><c:out value="${item.name}"></c:out></td>
										<td><c:out value="${item.state}"></c:out></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- 未応募 -->
				<input id="TAB02-05" type="radio" name="TAB02" class="tab-switch" /><label
					class="tab-label" for="TAB02-05">未応募</label>
				<div class="tab-content">
					<table>
						<tbody>
							<tr>
								<th>番号</th>
								<th>名前</th>
								<th>企業名</th>
							</tr>
							<c:forEach var="item" items="${stulist}">
								<c:if test="${item.state == '未応募'}" var="flg"></c:if>
								<c:if test="${flg}">
									<tr>
										<td><c:out value="${item.no}"></c:out></td>
										<td><c:out value="${item.name}"></c:out></td>
										<td><c:out value="${item.state}"></c:out></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form>
			<!-- </div> -->
		</article>

		<!-- 掲示板 -->
		<section class="side">
			<h1>About</h1>
			<p>メッセージ</p>
		</section>
	</div>


	<jsp:include page="footer.jsp" />

	<!-- <script src="js/main.js"></script> -->

	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>

</html>