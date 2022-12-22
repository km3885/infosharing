<!-- 訓練生情報CSVファイル管理画面 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/stuManagement.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
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
				<li class="list"><a href="StuinfoServlet?btn=normal"> <span
						class="icon"><ion-icon name="walk-outline"></ion-icon> </span> <span
						class="title">就活状況管理</span>
				</a></li>
				<li class="list active"><a href="ManagementServlet"> <span
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
		<div class="">

			<h2>令和４年度 情報システム科在校生名簿</h2>
			<p class="main-p">令和3年度 普通課程4科入校生（2年次） 入校式：令和3年4月12日（月）</p>
			<p class="main-p">令和4年度入校式：令和4年4月11日（月） 前期修了式：令和4年9月27日（火） 後期入校式：令和4年10月3日（月）
				修了式：令和5年3月10日（金）</p>
			<div class="main-btn">
			<form action="<%=request.getContextPath()%>/ManagementServlet"
				method="post">
				<button type="submit" name="btn" value="select" class="btn btn-primary">
				訓練生情報を更新
				</button>
			</form>
			<input type="button" value="csv形式でダウンロード" class="btn btn-secondary"
				onclick="location.href='FileMgmtServlet'">
			</div>

			<div class="main-table" div style="height:80%; width:1200px;  overflow-y:scroll;">
				<table class="table table-striped ">
					<thead>
						<tr>
							<c:forEach var="item" items="${headerlist}">
								<th class="table-danger"><c:out value="${item}" /></th>
							</c:forEach>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="student" items="${dataArray}">
							<tr>
								<td><c:out value="${student.getId()}" /></td>
								<td><c:out value="${student.getCategory()}" /></td>
								<td><c:out value="${student.getName()}" /></td>
								<td><c:out value="${student.getJurisdiction()}" /></td>
								<td><c:out value="${student.getNewGrad()}" /></td>
								<td><c:out value="${student.getApply()}" /></td>
								<td><c:out value="${student.getJobCard()}" /></td>
								<td><c:out value="${student.getPref()}" /></td>
								<td><c:out value="${student.getCoName()}" /></td>
								<td><c:out value="${student.getInternship()}" /></td>
								<td><c:out value="${student.getWorkAddress()}" /></td>
								<td><c:out value="${student.getEmpStatus()}" /></td>
								<td><c:out value="${student.getEmpInsurance()}" /></td>
								<td><c:out value="${student.getEmpperiod()}" /></td>
								<td><c:out value="${student.getEmpRoute()}" /></td>
								<td><c:out value="${student.getRelation()}" /></td>
								<td><c:out value="${sstudenttu.getPosition()}" /></td>
								<td><c:out value="${student.getDecidedDate()}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
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