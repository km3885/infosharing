<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./css/common.css">
  <link rel="stylesheet" href="./css/style.css">
  <title></title>
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
        <li class="list">
          <a href="StuinfoServlet">
            <span class="icon">
              <ion-icon name="people-circle-outline"></ion-icon>
            </span>
            <span class="title">訓練生情報</span>
          </a>
        </li>
        <li class="list active">
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

    <!-- コンテンツ -->
    <div class="col_2 stu-col2">
      <h2>イベント管理</h2>

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