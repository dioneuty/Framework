<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정페이지${fieldErrors }</h1>
	<form action="update.action">
		<div>
			<label for="sabun">사번</label>
			<input type="text" name="sabun" id="bean.sabun" value="${bean.sabun }" readonly/>
			${fieldErrors.errSabun }
		</div>
		<div>
			<label for="name">이름</label>
			<input type="text" name="name" id="bean.name" value="${bean.name }"/>
			${fieldErrors.errName }
		</div>
		<div>
			<label for="pay">금액</label>
			<input type="text" name="pay" id="bean.pay" value="${bean.pay }"/>
			${fieldErrors.errPay }
		</div>
		<button type="sumbit">수정</button>
		<button type="reset">취소</button>
	</form>	
</body>
</html>