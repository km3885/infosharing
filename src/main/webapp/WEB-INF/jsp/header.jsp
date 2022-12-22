<!-- ヘッダー用 jspファイル -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
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
                  <p class="name"><c:out value="${ac.userName}"></c:out></p>
              </div>
          </div>
      </header>

</body>
</html>