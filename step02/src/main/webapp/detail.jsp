<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div>div>span{
		display: inline-block;
		width: 150ps;
		background-color: gray;
	}
</style>
</head>
<body>
	<h1>상세페이지</h1>
	<div>
		<div><span>사번</span>${bean.sabun}</div>
		<div><span>이름</span>${bean.name}</div>
		<div><span>날짜</span>${bean.nalja}</div>
		<div><span>금액</span>${bean.pay}</div>
		<div>
			<a href="edit.action?sabun=${bean.sabun }">수정</a>
			<a href="del.action?sabun=${bean.sabun }">삭제</a>
		</div>
	</div>
</body>
</html>