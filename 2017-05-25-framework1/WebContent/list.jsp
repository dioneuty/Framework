<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- standard 1.1.2 jar, jstl-1.2.jar -->
<body>
	<h1>목록페이지</h1>
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>금액</th>
		</tr>
		<c:forEach items="${alist }" var="map">
		<tr>
			<td>${map.sabun }</td>
			<td><a href="detail.do?idx=${map.sabun }">${map.name }</a></td>
			<td>${map.nalja }</td>
			<td>${map.pay }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>