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
				<li class="list"><a href="StuinfoServlet"> <span
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
	
			<form action="ManagementServlet" method="post">
				<button type="submit">編集する</button>
			<table>
				<thead>
					<tr>
						<th></th>
						<th><c:out value="${dataArray[0].getId()}" /></th>
						<th><c:out value="${dataArray[0].getCategory()}" /></th>
						<th><c:out value="${dataArray[0].getName()}" /></th>
						<th><c:out value="${dataArray[0].getJurisdiction()}" /></th>
						<th><c:out value="${dataArray[0].getNewGrad()}" /></th>
						<th><c:out value="${dataArray[0].getApply()}" /></th>
						<th><c:out value="${dataArray[0].getJobCard()}" /></th>
						<th><c:out value="${dataArray[0].getPref()}" /></th>
						<th><c:out value="${dataArray[0].getCoName()}" /></th>
						<th><c:out value="${dataArray[0].getInternship()}" /></th>
						<th><c:out value="${dataArray[0].getWorkAddress()}" /></th>
						<th><c:out value="${dataArray[0].getEmpStatus()}" /></th>
						<th><c:out value="${dataArray[0].getEmpInsurance()}" /></th>
						<th><c:out value="${dataArray[0].getEmpperiod()}" /></th>
						<th><c:out value="${dataArray[0].getEmpRoute()}" /></th>
						<th><c:out value="${dataArray[0].getRelation()}" /></th>
						<th><c:out value="${dataArray[0].getPosition()}" /></th>
						<th><c:out value="${dataArray[0].getDecidedDate()}" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" begin="1" end="${count}" step="1">
						<tr>
							<td><input type="radio" name="id" value="${dataArray[i].getId()}"></td>
							<td><c:out value="${dataArray[i].getId()}" /></td>
							<td><c:out value="${dataArray[i].getCategory()}" /></td>
							<td><c:out value="${dataArray[i].getName()}" /></td>
							<td><c:out value="${dataArray[i].getJurisdiction()}" /></td>
							<td><c:out value="${dataArray[i].getNewGrad()}" /></td>
							<td><c:out value="${dataArray[i].getApply()}" /></td>
							<td><c:out value="${dataArray[i].getJobCard()}" /></td>
							<td><c:out value="${dataArray[i].getPref()}" /></td>
							<td><c:out value="${dataArray[i].getCoName()}" /></td>
							<td><c:out value="${dataArray[i].getInternship()}" /></td>
							<td><c:out value="${dataArray[i].getWorkAddress()}" /></td>
							<td><c:out value="${dataArray[i].getEmpStatus()}" /></td>
							<td><c:out value="${dataArray[i].getEmpInsurance()}" /></td>
							<td><c:out value="${dataArray[i].getEmpperiod()}" /></td>
							<td><c:out value="${dataArray[i].getEmpRoute()}" /></td>
							<td><c:out value="${dataArray[i].getRelation()}" /></td>
							<td><c:out value="${dataArray[i].getPosition()}" /></td>
							<td><c:out value="${dataArray[i].getDecidedDate()}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
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