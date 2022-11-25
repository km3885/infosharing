<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
javax.servlet.jsp.JspFactory jsp=javax.servlet.jsp.JspFactory.getDefaultFactory();
javax.servlet.jsp.JspEngineInfo engine = jsp.getEngineInfo();
%>

jsp version is
<%=engine.getSpecificationVersion()%>
</body>
</html>