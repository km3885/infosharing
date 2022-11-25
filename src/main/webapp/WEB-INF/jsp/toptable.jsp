<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>topTable</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<th>番号</th>
				<th>名前</th>
				<th>企業名</th>
			</tr>
			<c:forEach var="item" items="${stulist}">
				<c:choose>
					
					<c:when test="${item.state == '内定'}">
						<tr>
							<td><c:out value="${item.no}"></c:out></td>
							<td><c:out value="${item.name}"></c:out></td>
							<td><c:out value="${item.state}"></c:out></td>
						</tr>
					</c:when>

					
					<c:when test="${item.state == '選考中'}">
						<tr>
							<td><c:out value="${item.no}"></c:out></td>
							<td><c:out value="${item.name}"></c:out></td>
							<td><c:out value="${item.state}"></c:out></td>
						</tr>
					</c:when>

					
					<c:when test="${item.state == '書類作成中'}">
						<tr>
							<td><c:out value="${item.no}"></c:out></td>
							<td><c:out value="${item.name}"></c:out></td>
							<td><c:out value="${item.state}"></c:out></td>
						</tr>
					</c:when>

					
					<c:when test="${item.state == '応募済み'}">
						<tr>
							<td><c:out value="${item.no}"></c:out></td>
							<td><c:out value="${item.name}"></c:out></td>
							<td><c:out value="${item.state}"></c:out></td>
						</tr>
					</c:when>

					
					<c:when test="${item.state == '未応募'}">
						<tr>
							<td><c:out value="${item.no}"></c:out></td>
							<td><c:out value="${item.name}"></c:out></td>
							<td><c:out value="${item.state}"></c:out></td>
						</tr>
					</c:when>

				</c:choose>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>