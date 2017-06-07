<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/template/header.jsp"></jsp:include>
	<jsp:include page="/template/menu.jsp"></jsp:include>

	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li><a href="#">list</a></li>
		</ol>
	</div>

	<jsp:include page="/template/article.jsp">
		<jsp:param name="h1" value="List" />
		<jsp:param name="p" value="selectAll..." />
	</jsp:include>
	<div class="col-md-12">
		<div class="page-header">
			<h1>
				리스트 <small>게시판 목록</small>
			</h1>
		</div>
	</div>
	<div class="col-md-12">
		<table class="table table-hover">
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>날짜</th>
				<th>금액</th>
			</tr>
			<c:forEach items="${alist }" var="bean">
				<tr>
					<td><a href="detail.do?idx=${bean.sabun }">${bean.sabun }</a></td>
					<td><a href="detail.do?idx=${bean.sabun }">${bean.name }</a></td>
					<td><a href="detail.do?idx=${bean.sabun }">${bean.nalja }</a></td>
					<td><a href="detail.do?idx=${bean.sabun }">${bean.pay }</a></td>
				</tr>
			</c:forEach>

		</table>
		<a role="button" class="btn btn-primary" href="add.do">입력</a>

	</div>
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>