<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세페이지</h1>
	<div>sabun:${bean.sabun }</div>
	<div>name:${bean.name }</div>
	<div>nalja:${bean.nalja }</div>
	<div>pay:${bean.pay }</div>
	<a href="/guest/edit">수정</a>
	<a href="/guest/del?id=${bean.sabun }">삭제</a>
</body>
	
</html>