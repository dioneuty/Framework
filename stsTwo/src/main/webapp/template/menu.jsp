<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="row nav">
			<div class="col-md-12">
				<ul class="nav nav-tabs">
					<li role="presentation" class="${param.active == 1? 'active':null }"><a href="/day02/">Home</a></li>
					<li role="presentation" class="${param.active == 2? 'active':null }"><a href="/day02/user/list">UserList</a></li>
					<li role="presentation" class="${param.active == 3? 'active':null }"><a href="/day02/cntnt/list">PayList</a></li>
				</ul>
			</div>
		</div>
		<div class="row content">
			<div class="col-md-12 content">
				<div class="panel panel-default">
</body>
</html>