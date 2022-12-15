<!-- 訓練生情報CSV編集画面 -->

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
			<h2>訓練生情報管理</h2>
			Edit画面
			
			<form action="ManagementServlet" method="post" onSubmit="return check()">
				<p><label>入力 <input type="text" name="id" value="${stu.id}"></label></p>
				<p><label>科名 
					<select name="category">
						<c:forEach var="item" items="${categorylist}">
							<c:choose>
								<c:when test="${item == stu.category}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select></label></p>
				<p><label>氏名 <input type="text" name="name" value="${stu.name}"></label></p>
				<p><label>管轄 
					<select name="jurisdiction">
						<c:forEach var="item" items="${jurisdictionlist}">
							<c:choose>
								<c:when test="${item == stu.jurisdiction}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select></label></p>
				<p><label>新卒 
					<select name="newGrad">
						<c:forEach var="item" items="${newGradlist}">
							<c:choose>
								<c:when test="${item == stu.newGrad}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select></label></p>
				<p><label>適用 
					<select name="apply">
						<c:forEach var="item" items="${applylist}">
							<c:choose>
								<c:when test="${item == stu.apply}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select></label></p>
				<p><label>ジョブカード 
					<select name="jobCard">
						<c:forEach var="item" items="${jobCardlist}">
							<c:choose>
								<c:when test="${item == stu.jobCard}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select></label></p>
				<p><label>希望地 
					<select name="pref">
						<c:forEach var="item" items="${preflist}">
							<c:choose>
								<c:when test="${item == stu.pref}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select></label></p>
				<p><label>就職先 <input type="text" name="coName" value="${stu.coName}"></label></p>
				<p><label>実習先 
					<select name="internship">
						<c:forEach var="item" items="${internshiplist}">
							<c:choose>
								<c:when test="${item == stu.internship}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select></label></p>
				<p><label>勤務地住所 <input type="text" name="workAddress" value="${stu.workAddress}"></label></p>
				<p><label>雇用形態 
					<select name="empStatus">
						<c:forEach var="item" items="${empStatuslist}">
							<c:choose>
								<c:when test="${item == stu.empStatus}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select></label></p>
				<p><label>雇用保険 
					<select name="empInsurance">
						<c:forEach var="item" items="${empInsurancelist}">
							<c:choose>
								<c:when test="${item == stu.empInsurance}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select></label></p>
				<p><label>雇用期間 
					<select name="empperiod">
						<c:forEach var="item" items="${empperiodlist}">
							<c:choose>
								<c:when test="${item == stu.empperiod}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select></label></p>
				<p><label>就職経路 
					<select name="empRoute">
						<c:forEach var="item" items="${empRoutelist}">
							<c:choose>
								<c:when test="${item == stu.empRoute}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select></label></p>
				<p><label>関連 
					<select name="relation">
						<c:forEach var="item" items="${relationlist}">
							<c:choose>
								<c:when test="${item == stu.relation}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select></label></p>
				<p><label>職種 <input type="text" name="position" value="${stu.position}"></label></p>
				<p><label>内定日 <input type="text" name="decidedDate" value="${stu.decidedDate}"></label></p>
				<p><button type="submit" name="btn" value="update">更新</button></p>
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