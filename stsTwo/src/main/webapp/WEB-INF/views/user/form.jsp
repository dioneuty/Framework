<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/template/header.jsp"></jsp:include>
	<jsp:include page="/template/menu.jsp">
		<jsp:param value="2" name="active" />
	</jsp:include>
	<div class="panel-body">
		<div class="page-header">
			<h1>
				입력페이지<small>Form페이지</small>
			</h1>
			<form class="form-horizontal" method="post">
				<div class="form-group">
					<label for="sabun" class="col-sm-2 control-label">sabun</label>
					<div class="col-sm-10">
						<input type="text" name="sabun" class="form-control" id="sabun"
							placeholder="sabun">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">name</label>
					<div class="col-sm-10">
						<input type="text" name="name" class="form-control" id="name"
							placeholder="name">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary btn-block">입력</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>