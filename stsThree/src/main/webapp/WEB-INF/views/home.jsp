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
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/day03/"> 
					<p>한빛교육센터</p>
				</a>
				<a href="" class="navbar-text">MENU1</a>
				<a href="/day03/list" class="navbar-text">List</a>
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
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="resources/imgs/big01.jpg" alt="..." />
						<div class="carousel-caption">...</div>
					</div>
					<div class="item">
						<img src="resources/imgs/big02.jpg" alt="..." />
						<div class="carousel-caption">...</div>
					</div>
					<div class="item">
						<img src="resources/imgs/big03.jpg" alt="..." />
						<div class="carousel-caption">...</div>
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
</body>
</html>