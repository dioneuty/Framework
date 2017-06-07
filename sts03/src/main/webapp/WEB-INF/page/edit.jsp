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
		  <li><a>addForm</a></li>
		</ol>
	</div>
	<jsp:include page="/template/article.jsp">
		<jsp:param value="AddForm" name="h1"/>
		<jsp:param value="form..." name="p"/>
	</jsp:include>
	<div class="col-md-12">
		<div class="page-header">
		  <h1>입력페이지 <small>수정</small></h1>
		</div>
	</div>	
	<div class="col-md-12">
		<form class="form-horizontal" action="update.do">
		  <div class="form-group">
		    <label for="sabun" class="col-sm-2 control-label">사번</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" value="${bean.sabun }" name="sabun" id="sabun" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="name" class="col-sm-2 control-label">이름</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" value="${bean.name }" name="name" id="name" placeholder="NAME">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="pay" class="col-sm-2 control-label">금액</label>
		    <div class="col-sm-10">
		      <input type="number" class="form-control" value="${bean.pay }" name="pay" id="pay" placeholder="PAY">
		    </div>
		  </div>

		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">입력</button>
		    </div>
		  </div>
		</form>
	</div>
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>
