<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리스트페이지</h1>
	<div>
		<div>
			<span>사번</span>
			<span>이름</span>
			<span>날짜</span>
			<span>금액</span>
		</div>
		<c:forEach items="${alist }" var="bean">
		<a href="detail.action?sabun=${bean.sabun }">
		<div>
			<span>${bean.sabun }</span>
			<span>${bean.name }</span>
			<span>${bean.nalja }</span>
			<span>${bean.pay }</span>	
		</div>
		</a>
		</c:forEach>
	</div>	
	<a href="add.action">입력</a>	
</body>
</html>