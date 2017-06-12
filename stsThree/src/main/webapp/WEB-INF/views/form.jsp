<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<li><a href="/day03/list">list</a></li>
				<li><a href="/day03/guest">add</a></li>
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
							<li><a href="/day03/list">목록</a></li>
							<li class="active"><a href="/day03/guest">글쓰기</a></li>
						</ul>
					</div>
					<div class="panel-footer"></div>
				</div>
			</dlv>
			<div class="col-md-8">
				<div class="page-header">
					<h1>
						입력 <small>입력 페이지</small>
					</h1>
				</div>
				<form class="form-horizontal" method="post">
					<div class="form-group">
						<label for="sabun" class="col-sm-2 control-label">사번</label>
						<div class="col-sm-10">
							<input type="text" name="sabun" id="sabun" class="form-control" id="inputEmail3"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<input type="text" name="name" id="name" class="form-control" id="inputEmail3"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="pay" class="col-sm-2 control-label">금액</label>
						<div class="col-sm-10">
							<input type="number" name="pay" id="pay" class="form-control" id="inputEmail3"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">입력</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>