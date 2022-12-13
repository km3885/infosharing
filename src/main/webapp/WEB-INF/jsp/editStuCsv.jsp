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
				<p><label>科名 <input type="text" name="no" value="${stu.category}"></label></p>
				<p><label>氏名 <input type="text" name="name" value="${stu.name}"></label></p>
				<p><label>管轄 <input type="text" name="id" value="${stu.jurisdiction}"></label></p>
				<p><label>新卒 <input type="text" name="no" value="${stu.newGrad}"></label></p>
				<p><label>適用 <input type="text" name="name" value="${stu.apply}"></label></p>
				<p><label>ジョブカード <input type="text" name="no" value="${stu.jobCard}"></label></p>
				<p><label>希望地 <input type="text" name="name" value="${stu.pref}"></label></p>
				<p><label>就職先 <input type="text" name="id" value="${stu.coName}"></label></p>
				<p><label>実習先 <input type="text" name="no" value="${stu.internship}"></label></p>
				<p><label>勤務地住所 <input type="text" name="name" value="${stu.workAddress}"></label></p>
				<p><label>雇用形態 <input type="text" name="id" value="${stu.empStatus}"></label></p>
				<p><label>雇用保険 <input type="text" name="no" value="${stu.empInsurance}"></label></p>
				<p><label>雇用期間 <input type="text" name="name" value="${stu.empperiod}"></label></p>
				<p><label>就職経路 <input type="text" name="no" value="${stu.empRoute}"></label></p>
				<p><label>関連 <input type="text" name="name" value="${stu.relation}"></label></p>
				<p><label>職種 <input type="text" name="no" value="${stu.position}"></label></p>
				<p><label>内定日 <input type="text" name="name" value="${stu.decidedDate}"></label></p>
				
				
				
				
				<p><label>就活状況
					<select name="state">
						<c:forEach var="item" items="${selectlist}">
							<c:choose>
								<c:when test="${item == stu1.state}">
									<option selected>${item}</option>
								</c:when>
								<c:otherwise>
									<option>${item}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</select>
				</label></p>
				<p><label>企業名 <input type="text" name="coName" value="${stu1.coName}"></label></p>
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