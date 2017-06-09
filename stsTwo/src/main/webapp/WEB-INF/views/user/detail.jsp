<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/template/header.jsp"></jsp:include>
	<jsp:include page="/template/menu.jsp">
		<jsp:param value="2" name="active" />
	</jsp:include>
	<div class="panel-body">
		<div class="page-header">
			<h1>
				상세 페이지<small> ${bean.name }님의 정보입니다.</small>
			</h1>
		</div>
		<ul class="list-group">
			<li class="list-group-item">
				<h2>번호</h2>${bean.num }
			</li>
			<li class="list-group-item">
				<h2>사번</h2>${bean.sabun }
			</li>
			<li class="list-group-item">
				<h2>이름</h2>${bean.name }
			</li>
			<li class="list-group-item">
				<h2>날짜</h2>${bean.nalja }
			</li>
		</ul>
		<table class="table table-condensed">
			<tr>
				<th>no</th>
				<th>사번</th>
				<th>이름</th>
				<th>날짜</th>
			</tr>
			<c:forEach items="${alist }" var="bean">
				<tr>
					<td>${bean.num }</td>
					<td>${bean.sabun }</td>
					<td>${bean.name }</td>
					<td>${bean.nalja }</td>
				</tr>
			</c:forEach>
		</table>
		<div class="btn-group btn-group-justified btn-group-lg" role="group" aria-label="...">
			<a href="edit?idx=${bean.num }" class="btn btn-primary" role="button">수정</a>
			<a href="del?idx=${bean.num }" class="btn btn-danger" role="button">삭제</a>
		</div>
	</div>
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>