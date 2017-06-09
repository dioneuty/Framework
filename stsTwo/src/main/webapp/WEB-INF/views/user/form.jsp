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
				${title }페이지<small>Form페이지</small>
			</h1>
			<form class="form-horizontal" action="${nxturl }" method="post">
				<input type="hidden" name="num" value="${bean.num==null?0:bean.num }" />
				<div class="form-group">
					<label for="sabun" class="col-sm-2 control-label">사번</label>
					<div class="col-sm-10">
						<input type="text" value="${bean.sabun }" name="sabun" class="form-control" id="sabun"
							placeholder="사번"/>
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">이름</label>
					<div class="col-sm-10">
						<input type="text" value="${bean.name }" name="name" class="form-control" id="name"
							placeholder="이름"/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary btn-block">${title }</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>