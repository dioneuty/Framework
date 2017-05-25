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
	
	<div>
		<div>
			<span>사번</span>
			<span>${bean.sabun }</span>
		</div>
	</div>
	<div>
		<div>
			<span>이름</span>
			<span>${bean.name }</span>
		</div>
	</div>
	<div>
		<div>
			<span>날짜</span>
			<span>${bean.nalja }</span>
		</div>
	</div>
	<div>
		<div>
			<span>금액</span>
			<span>${bean.pay }</span>
		</div>
	</div>
	
</body>
</html>