<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <header>
          <div class="wrapper">
              <div class="header-left">
                  <h1>訓練生就活状況共有ツール</h1>
              </div>
              <div class="header-right">
                  <ion-icon name="person-circle-outline" class="user-icon"></ion-icon>
                  <p class="name">ログインID</p>
              </div>
          </div>
      </header>

  <div class="col">
    <!-- サイドメニュー -->
    <aside class="navigation">
      <ul>
        <li class="list">
          <a href="TopServlet">
            <span class="icon">
              <ion-icon name="home-outline"></ion-icon>
            </span>
            <span class="title">ホーム</span>
          </a>
        </li>
        <li class="list active">
          <a href="StuinfoServlet">
            <span class="icon">
              <ion-icon name="people-circle-outline"></ion-icon>
            </span>
            <span class="title">訓練生情報</span>
          </a>
        </li>
        <li class="list">
          <a href="EventInfoServlet">
            <span class="icon">
              <ion-icon name="calendar-outline"></ion-icon>
            </span>
            <span class="title">イベント管理</span>
          </a>
        </li>
        <li class="list">
          <a href="AccessInfoServlet">
            <span class="icon">
              <ion-icon name="shield-checkmark-outline"></ion-icon>
            </span>
            <span class="title">アクセス権限</span>
          </a>
        </li>
        <li class="btn-logout">
          <a href="#">
            <span class="icon">
              <ion-icon name="log-out-outline"></ion-icon>
            </span>
            <span class="title">ログアウト</span>
          </a>
        </li>
      </ul>
    </aside>

    <!-- contents -->
    <div class="col_2 stu-col2">
      <h2>訓練生情報</h2>
      <form action="<%= request.getContextPath() %>/StuinfoServlet" method="post">
        <div class="dd-list">
          <label for="name">名前:</label>
          <select name="stu_name">
	          <option>▼選択してください</option>
	          <option value="2401">佐藤 碧</option>
	          <option value="2402">鈴木 陽葵</option>
	          <option value="2403">高橋 陽翔</option>
	          <option value="2404">田中 凛</option>
	          <option value="2405">伊藤 蒼</option>
          </select>
          <button>見る</button>
        </div>
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
    
    <div>
    	<p>結果</p>
    	<%= request.getAttribute("stu") %>
    </div>
  </div>



  <footer>フッター</footer>

  <!-- <script src="js/main.js"></script> -->

  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
  <script>

  </script>
</body>

</html>