<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<jsp:include page="/template/article.jsp">
		<jsp:param name="h1" value="List"/>
		<jsp:param name="p" value="Here is List (SelectAll)"/>
	</jsp:include>
	<div class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li><a href="#">List</a></li>
		</ol>
	</div>
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
				<td>${bean.sabun }</td>
				<td>${bean.name }</td>
				<td>${bean.nalja }</td>
				<td>${bean.pay }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="/template/menu.jsp"></jsp:include>
</body>



</html>