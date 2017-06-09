<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	 integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	 crossorigin="anonymous">
	</script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<!-- 	<script type="text/javascript" src="resources/js/carousel.js"></script> -->
	<title>Insert title here</title>
	<script>
	$('document').ready(function(){
		$('.carousel').carousel({
			 interval: 2000
		});
	});
	</script>
</head>

<body>
	<div class="container-fluid">
		<div class="row header"> 
			<div class="col-md-12">
				<div class="jumbotron">
				    <h1>Hello, world!</h1>
				    <p>...</p>
				    <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
				</div>
			</div>
		</div>
		<div class="row nav">
			<div class="col-md-12">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="#">Home</a></li>
					<li role="presentation"><a href="user/list">List</a></li>
					<li role="presentation"><a href="user/cntnt">Cntnt</a></li>
				</ul>
			</div>
		</div>
		<div class="row content">
			<div class="col-md-12 content">
				<div class="panel panel-default">
					<div class="panel-body">
						<!-- content start -->
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
									<img src="resources/imgs/big01.jpg" alt="...">
									<div class="carousel-caption">image01</div>
								</div>
								<div class="item">
									<img src="resources/imgs/big02.jpg" alt="...">
									<div class="carousel-caption">image02</div>
								</div>
								<div class="item">
									<img src="resources/imgs/big03.jpg" alt="...">
									<div class="carousel-caption">image03</div>
								</div>
							</div>

							<!-- Controls -->
							<a class="left carousel-control" href="#carousel-example-generic"
								role="button" data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
								<span class="sr-only">Previous</span>
							</a> 
							<a class="right carousel-control"
								href="#carousel-example-generic" role="button" data-slide="next">
								<span class="glyphicon glyphicon-chevron-right"
								aria-hidden="true"></span> <span class="sr-only">Next</span>
							</a>
						</div>
						<!-- content end -->
					</div>
					<div class="panel-footer footer">
						(주)한빛이엔아이 ｜ 사업자등록번호 : 220-85-43667 ｜ 
						통신판매신고 : 마포 제 0358호
						한빛ENI : 02-707-1480 / (121-854) 서울시 마포구 신수동 
						63-14 구프라자 3층 / 대표이사 : 염기호
						개인정보보호관리책임자 : 허윤
						Copyright (c) 2015 한빛교육센터 All rights reserved.
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>