<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/day03/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="/day03/resources/css/bootstrap-theme.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/day03/resources/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	var param = ${bean.sabun};

	$('document').ready(function(){
		$('#update').hide();
		$("#detail button").eq(0).click(function() {
			$("#update").show();
			$("#detail").hide();
			$(".page-header small").text("수정페이지");
		}).next().click(function() {
			if(window.confirm(param+"님 삭제하시겠습니까?")){
				$.ajax({
					headers :{"X-HTTP-Method-Override":"DELETE" },
					method: 'DELETE',
				    contentType: 'application/json',
					dataType: 'text',
					success:function(){
						window.location.replace("/day03/list");
					}
				});
			}
		});
	});
</script>
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
						${bean.name }의 정보 <small>상세 페이지</small>
					</h1>
				</div>
				<div id="detail" class="panel panel-default">
					<div class="panel-heading"></div>
					<div class="panel-body">
						<dl class="dl-horizontal">
							<dt>사번</dt>
							<dd>${bean.sabun }</dd>
							<dt>이름</dt>
							<dd>${bean.name }</dd>
							<dt>날짜</dt>
							<dd>${bean.nalja }</dd>
							<dt>금액</dt>
							<dd>${bean.pay }</dd>
						</dl>
					</div>
					<button>수정</button>
					<button>삭제</button>
				</div>

				<div id="update">
					<form class="form-horizontal" method="post">
						<!-- web.xml -> HiddenHttpMethodFilter 클래스 filter 등록 --> 
						<input type="hidden" name="_method" value="put" />
						<div class="form-group">
							<label for="sabun" class="col-sm-2 control-label">사번</label>
							<div class="col-sm-10">
								<input type="text" name="sabun" id="sabun" value="${bean.sabun }" class="form-control"
									id="inputEmail3" placeholder="Email" readonly >
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">이름</label>
							<div class="col-sm-10">
								<input type="text" name="name" id="name" value="${bean.name }" class="form-control"
									id="inputEmail3" placeholder="Email">
							</div>
						</div>
						<div class="form-group">
							<label for="pay" class="col-sm-2 control-label">금액</label>
							<div class="col-sm-10">
								<input type="number" name="pay" id="pay" value="${bean.pay }" class="form-control"
									id="inputEmail3" placeholder="Email">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">수정</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>				