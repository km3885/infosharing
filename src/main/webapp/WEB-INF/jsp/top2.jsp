<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Document</title>
  <!-- <link rel="stylesheet" href="css/common.css" /> -->
  <link rel="stylesheet" href="css/style.css">
</head>

<body>
  <header>
    <div class="wrapper">
      <div class="header-left">
        <h1>タイトルタイトルタイトル</h1>
      </div>
      <div class="header-right">
        <ion-icon name="person-circle-outline" class="user-icon"></ion-icon>
        <ion-icon name="person-circle-sharp" class="user-icon"></ion-icon>
        <p class="name">name</p>
      </div>
    </div>
  </header>

  <div class="col">

    <aside class="navigation">
      <ul>
        <li class="list active">
          <a href="#">
            <span class="icon">
              <ion-icon name="home-outline"></ion-icon>
            </span>
            <span class="title">ホーム</span>
          </a>
        </li>
        <li class="list">
          <a href="#">
            <span class="icon">
              <ion-icon name="person-circle-outline"></ion-icon>
            </span>
            <span class="title">内定</span>
          </a>
        </li>
        <li class="list">
          <a href="#">
            <span class="icon">
              <ion-icon name="tv-outline"></ion-icon>
            </span>
            <span class="title">選考中</span>
          </a>
        </li>
        <li class="list">
          <a href="#">
            <span class="icon">
              <ion-icon name="settings-outline"></ion-icon>
            </span>
            <span class="title">書類作成中</span>
          </a>
        </li>
        <li class="list">
          <a href="#">
            <span class="icon">
              <ion-icon name="id-card-outline"></ion-icon>
            </span>
            <span class="title">応募済み</span>
          </a>
        </li>
        <li class="list">
          <a href="#">
            <span class="icon">
              <ion-icon name="help-circle-outline"></ion-icon>
            </span>
            <span class="title">未応募</span>
          </a>
        </li>

        <li class="btn btn1">
          <a href="#">
            <span class="icon">
              <ion-icon name="people-circle-outline"></ion-icon>
            </span>
            <span class="title">訓練生情報</span>
          </a>
        </li>
        <li class="btn">
          <a href="#">
            <span class="icon">
              <ion-icon name="log-out-outline"></ion-icon>
            </span>
            <span class="title">ログアウト</span>
          </a>
        </li>
      </ul>
    </aside>

    <div class="col_2">
      <h2>タイトル</h2>
      <table style="border: 1px solid black;">
        <thead>
          <tr>
            <th>番号</th>
            <th>氏名</th>
            <th>会社名</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>00</td>
            <td>斎藤 斎藤</td>
            <td>株式会社○○○○○○○○</td>
          </tr>

        </tbody>
      </table>
    </div>
    <div class="col_3">
      ここに内容
    </div>
  </div>

  <footer>フッター</footer>
  </div>


  </div>

  <script src="js/main.js"></script>

  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
  <script>

  </script>
</body>

</html>