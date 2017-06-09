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
	<jsp:include page="/template/header.jsp"></jsp:include>
	<jsp:include page="/template/menu.jsp">
		<jsp:param value="1" name="active"/>
	</jsp:include>
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
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>

</html>