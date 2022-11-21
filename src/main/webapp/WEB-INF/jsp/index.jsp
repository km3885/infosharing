<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css">
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/styleadmin.css">
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
                  <!-- 
                  <ion-icon name="person-circle" class="user-icon"></ion-icon>
                  <ion-icon name="person-circle-sharp" class="user-icon"></ion-icon>
                   -->
                  <p class="name">ログイン氏名</p>
              </div>
          </div>
      </header>


  <div class="col">
    <!-- サイドメニュー -->
    <aside class="navigation">
      <ul>
        <li class="list active">
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
          <a href="LogoutServlet">
            <span class="icon">
              <ion-icon name="log-out-outline"></ion-icon>
            </span>
            <span class="title">ログアウト</span>
          </a>
        </li>
      </ul>
    </aside>

    <!-- コンテンツ -->
    <div class="contents">
      <!-- 就活状況 -->
      <div class="first-elements">
        <input id="TAB02-01" type="radio" name="TAB02" class="tab-switch" checked="checked" /><label class="tab-label"
          for="TAB02-01">内定</label>
        <div class="tab-content">

        </div>
        <input id="TAB02-02" type="radio" name="TAB02" class="tab-switch" /><label class="tab-label"
          for="TAB02-02">選考中</label>
        <div class="tab-content">

        </div>
        <input id="TAB02-03" type="radio" name="TAB02" class="tab-switch" /><label class="tab-label"
          for="TAB02-03">書類作成中</label>
        <div class="tab-content">

        </div>
        <input id="TAB02-04" type="radio" name="TAB02" class="tab-switch" /><label class="tab-label"
          for="TAB02-04">応募済み</label>
        <div class="tab-content">

        </div>
        <input id="TAB02-05" type="radio" name="TAB02" class="tab-switch" /><label class="tab-label"
          for="TAB02-05">未応募</label>
        <div class="tab-content">

        </div>
        
      </div>

      <!-- カレンダー -->
      <div class="second-elements">
        内容2
      </div>

      <!-- 掲示板 -->
      <div class="third-elements">
        内容3
      </div>
    </div>

    <!-- <div class="col_3">
      ここに内容2
    </div> -->
  </div>



  <footer>フッター</footer>

  <!-- <script src="js/main.js"></script> -->

  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>

</html>