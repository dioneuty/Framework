<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력페이지</h1>
	<form action="insert.do" method="post">
		<label for="sabun">사번</label><input type="text" name="sabun" id="sabun">
		<label for="name">이름</label><input type="text" name="name" id="name">
		<label for="pay">금액</label><input type="text" name="pay" id="pay">
		<button>입력</button>
	</form>
</body>
</html>