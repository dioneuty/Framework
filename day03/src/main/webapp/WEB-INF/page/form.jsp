<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${title }페이지</h1>
	<form action="${nxtURI }" method="post">
	<input type="hidden" name="sabun" value="${bean.sabun }">
	<div><label for="name">이름</label>
		<input type="text" id="name" name="name" value="${bean.name }"/> </div>
	<div><label for="nalja">날짜</label>
		<input type="date" id="nalja" name="nalja" value="${bean.nalja }"/> </div>
	<div><label for="pay">금액</label>
		<input type="text" id="pay" name="pay" value="${bean.pay }"/> </div>
	<div><button type="submit">${title }</button>
			<button type="reset">취소</button> </div>	
	</form>
</body>
</html>