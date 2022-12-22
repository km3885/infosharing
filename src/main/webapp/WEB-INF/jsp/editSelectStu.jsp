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
				<li class="list"><a href="TopServlet"> <span
						class="icon"> <ion-icon name="home-outline"></ion-icon>
					</span> <span class="title">ホーム</span>
				</a></li>
				<li class="list"><a href="StuinfoServlet?btn=normal"> <span
						class="icon"><ion-icon name="walk-outline"></ion-icon> 
					</span> <span class="title">就活状況管理</span>
				</a></li>
				<li class="list active"><a href="ManagementServlet"> <span
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

		<!-- コンテンツ -->
		<div class="col_2 stu-col2">
		
			<h2>令和４年度　 情報システム科在校生名簿</h2>
			<p> 令和3年度 普通課程4科入校生（2年次） 入校式：令和3年4月12日（月）</p>
			<p> 令和4年度入校式：令和4年4月11日（月）  前期修了式：令和4年9月27日（火）  後期入校式：令和4年10月3日（月）  修了式：令和5年3月10日（金）</p>
	
			<div class="main-table" div style="height:80%; width:1200px;  overflow-y:scroll;">
			<form action="ManagementServlet" method="post">
				<button type="submit" name="btn" value="edit" class="btn btn-primary">編集する</button>
				<p style="color:red;">※編集する訓練生を選択してください</p>
			<table class="table table-striped ">
				<thead>
					<tr>
					<th class="table-danger"></th>
					<c:forEach var="item" items="${headerlist}">
						<th class="table-danger"><c:out value="${item}" /></th>
					</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="stu" items="${dataArray}">
						<tr>
							<td><input type="radio" name="id" value="${stu.getId()}"></td>
							<td><c:out value="${stu.getId()}" /></td>
							<td><c:out value="${stu.getCategory()}" /></td>
							<td><c:out value="${stu.getName()}" /></td>
							<td><c:out value="${stu.getJurisdiction()}" /></td>
							<td><c:out value="${stu.getNewGrad()}" /></td>
							<td><c:out value="${stu.getApply()}" /></td>
							<td><c:out value="${stu.getJobCard()}" /></td>
							<td><c:out value="${stu.getPref()}" /></td>
							<td><c:out value="${stu.getCoName()}" /></td>
							<td><c:out value="${stu.getInternship()}" /></td>
							<td><c:out value="${stu.getWorkAddress()}" /></td>
							<td><c:out value="${stu.getEmpStatus()}" /></td>
							<td><c:out value="${stu.getEmpInsurance()}" /></td>
							<td><c:out value="${stu.getEmpperiod()}" /></td>
							<td><c:out value="${stu.getEmpRoute()}" /></td>
							<td><c:out value="${stu.getRelation()}" /></td>
							<td><c:out value="${stu.getPosition()}" /></td>
							<td><c:out value="${stu.getDecidedDate()}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			</form>
			
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