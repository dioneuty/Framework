<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/table.css" type="text/css">
<style type="text/css">
	
</style>
</head>
<body>
	<h1>리스트페이지</h1>
	
	<div id="table">
		<div class="tr">
			<span>사번</span>
			<span>이름</span>
			<span>날짜</span>
			<span>금액</span>
		</div>
		<c:forEach items="${alist }" var="bean">
		<div class="tr">
			<span>${bean.sabun }</span>
			<span>${bean.name }</span>
			<span>${bean.nalja }</span>
			<span>${bean.pay }</span>
		</div>
		</c:forEach>
	</div>
	<a href="add.do">입력</a>
</body>
</html>