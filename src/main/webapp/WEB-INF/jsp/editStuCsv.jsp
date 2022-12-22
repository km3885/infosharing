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
<link rel="stylesheet" href="./css/stuManagement.css">
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
		<div class="main-col">
			<h2>訓練生情報管理</h2>
			Edit画面
			<form action="ManagementServlet" method="post" class="edit-form"
				onSubmit="return check()">
				<table class="main-table">
					<tr>
						<th><label>入力</label></th>
						<td><input type="text" class="hoge" name="id" value="${stuselect.id}"></td>
					</tr>

					<tr>
						<th><label>科名</label></th>
						<td><select name="category" class="hoge">
								<c:forEach var="item" items="${categorylist}">
									<c:choose>
										<c:when test="${item == stuselect.category}">
											<option selected>${item}</option>
										</c:when>
										<c:otherwise>
											<option>${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th><label>氏名</label></th>
						<td><input type="text" class="hoge" name="name" value="${stuselect.name}"></td>
					</tr>
					<tr>
						<th><label>管轄</label></th>
						<td><select name="jurisdiction" class="hoge">
								<c:forEach var="item" items="${jurisdictionlist}">
									<c:choose>
										<c:when test="${item == stuselect.jurisdiction}">
											<option selected>${item}</option>
										</c:when>
										<c:otherwise>
											<option>${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th><label>新卒</label></th>
						<td><select name="newGrad" class="hoge">
								<c:forEach var="item" items="${newGradlist}">
									<c:choose>
										<c:when test="${item == stuselect.newGrad}">
											<option selected>${item}</option>
										</c:when>
										<c:otherwise>
											<option>${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th><label>適用</label></th>
						<td><select name="apply" class="hoge">
								<c:forEach var="item" items="${applylist}">
									<c:choose>
										<c:when test="${item == stuselect.apply}">
											<option selected>${item}</option>
										</c:when>
										<c:otherwise>
											<option>${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th><label>ジョブカード</label></th>
						<td><select name="jobCard" class="hoge">
								<c:forEach var="item" items="${jobCardlist}">
									<c:choose>
										<c:when test="${item == stuselect.jobCard}">
											<option selected>${item}</option>
										</c:when>
										<c:otherwise>
											<option>${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th><label>希望地</label></th>
						<td><select name="pref" class="hoge">
								<c:forEach var="item" items="${preflist}">
									<c:choose>
										<c:when test="${item == stuselect.pref}">
											<option selected>${item}</option>
										</c:when>
										<c:otherwise>
											<option>${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th><label>就職先</label></th>
						<td><input type="text" class="hoge" name="coName"
							value="${stuselect.coName}"></td>
					</tr>
					<tr>
						<th><label>実習先</label></th>
						<td><select name="internship" class="hoge">
								<c:forEach var="item" items="${internshiplist}">
									<c:choose>
										<c:when test="${item == stuselect.internship}">
											<option selected>${item}</option>
										</c:when>
										<c:otherwise>
											<option>${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th><label>勤務地住所</label></th>
						<td><input type="text" class="hoge" name="workAddress"
							value="${stuselect.workAddress}"></td>
					</tr>
					<tr>
						<th><label>雇用形態</label></th>
						<td><select name="empStatus" class="hoge">
								<c:forEach var="item" items="${empStatuslist}">
									<c:choose>
										<c:when test="${item == stuselect.empStatus}">
											<option selected>${item}</option>
										</c:when>
										<c:otherwise>
											<option>${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th><label>雇用保険</label></th>
						<td><select name="empInsurance" class="hoge">
								<c:forEach var="item" items="${empInsurancelist}">
									<c:choose>
										<c:when test="${item == stuselect.empInsurance}">
											<option selected>${item}</option>
										</c:when>
										<c:otherwise>
											<option>${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th><label>雇用期間</label></th>
						<td><select name="empperiod" class="hoge">
								<c:forEach var="item" items="${empperiodlist}">
									<c:choose>
										<c:when test="${item == stuselect.empperiod}">
											<option selected>${item}</option>
										</c:when>
										<c:otherwise>
											<option>${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th><label>就職経路</label></th>
						<td><select name="empRoute" class="hoge">
								<c:forEach var="item" items="${empRoutelist}">
									<c:choose>
										<c:when test="${item == stuselect.empRoute}">
											<option selected>${item}</option>
										</c:when>
										<c:otherwise>
											<option>${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th><label>関連</label></th>
						<td><select name="relation" class="hoge">
								<c:forEach var="item" items="${relationlist}">
									<c:choose>
										<c:when test="${item == stuselect.relation}">
											<option selected>${item}</option>
										</c:when>
										<c:otherwise>
											<option>${item}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th><label>職種</label></th>
						<td><input type="text" class="hoge" name="position"
							value="${stuselect.position}"></td>
					</tr>
					<tr>
						<th><label>内定日</label></th>
						<td><input type="date" class="hoge" name="decidedDate"
							value="${stuselect.decidedDate}" min="2018-01-01"
							max="2023-12-31"></td>
					</tr>
				</table>
				<button type="submit" name="btn" value="update">更新</button>

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