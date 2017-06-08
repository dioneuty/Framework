<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정페이지</h1>
	<form action="../update" method="post">
		<div>
			<label for="sabun">사번</label>
			<input type="text" name="sabun" id="sabun" value=${bean.sabun} readonly>
		</div>
		<div>
			<label for="name">이름</label>
			<input type="text" name="name" id="name" value=${bean.name}>
		</div>
		<div>
			<label for="nalja">날짜</label>
			<input type="date" name="nalja" id="nalja" value=${bean.nalja} disabled>
		</div>
		<div>
			<label for="pay">금액</label>
			<input type="text" name="pay" id="pay" value=${bean.pay}>
		</div>
		<div>
			<button>수정</button>
		</div>
	</form>
</body>
</html>