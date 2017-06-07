<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" >
	<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/bootstrap.min.js" ></script>
</head>
<body>
	<jsp:include page="/template/header.jsp"></jsp:include>
	<jsp:include page="/template/menu.jsp"></jsp:include>
	<div class="col-md-12">
		<ol class="breadcrumb">
		  <li><a href="./">Home</a></li>
		  <li><a href="list.do">list</a></li>
		  <li><a>detail</a></li>
		</ol>
	</div>
	<jsp:include page="/template/article.jsp">
		<jsp:param value="DETAIL" name="h1"/>
		<jsp:param value="..." name="p"/>
	</jsp:include>
	<div class="col-md-12">
		<div class="page-header">
		  <h1>상세보기 <small>${bean.sabun }님의 내용</small></h1>
		</div>
	</div>	
	<div class="col-md-3 col-md-offset-3 text-right">
	사번
	</div>	
	<div class="col-md-3">
	${bean.sabun }
	</div>	
	<div class="col-md-3 col-md-offset-3 text-right">
	이름
	</div>	
	<div class="col-md-3">
	${bean.name }
	</div>	
	<div class="col-md-3 col-md-offset-3 text-right">
	날짜
	</div>	
	<div class="col-md-3">
	${bean.nalja }
	</div>	
	<div class="col-md-3 col-md-offset-3 text-right">
	금액
	</div>	
	<div class="col-md-3">
	${bean.pay }
	</div>	
	<div class="col-md-6 col-md-offset-3 text-center">
		<a role="button" class="btn btn-primary" href="edit.do?idx=${bean.sabun }">수정</a>
	
		<a role="button" class="btn btn-danger" href="delete.do?idx=${bean.sabun }">삭제</a>
	</div>	
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>