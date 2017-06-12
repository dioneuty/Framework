<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/day03/"> 
					<p>한빛교육센터</p>
				</a>
				<a href="" class="navbar-text">MENU1</a>
				<a href="" class="navbar-text">MENU2</a>
				<a href="" class="navbar-text">GUEST</a>	
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="/day03/">Home</a></li>
			</ol>
		</div>
		<div class="row">
			<dlv class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Panel title</h3>
					</div>
					<div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
							<li class="active"><a href="/day03/list">목록</a></li>
							<li><a href="/day03/guest">글쓰기</a></li>
						</ul>
					</div>
					<div class="panel-footer"></div>
				</div>
			</dlv>
			<div class="col-md-8">
				<div class="page-header">
					<h1>
						목록 <small>리스트 페이지</small>
					</h1>
				</div>
				<table class="table table-hover">
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>날짜</th>
						<th>금액</th>
					</tr>
					<c:forEach items="${alist }" var="bean">
						<tr>
							<td><a href="guest/${bean.sabun}">${bean.sabun }</a></td>
							<td><a href="guest/${bean.sabun}">${bean.name }</a></td>
							<td><a href="guest/${bean.sabun}">${bean.nalja }</a></td>
							<td><a href="guest/${bean.sabun}">${bean.pay }</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>	
</body>
</html>