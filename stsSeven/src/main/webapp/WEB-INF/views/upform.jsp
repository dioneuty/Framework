<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
		<div>
			<label for="sabun">sabun</label>
			<input type="text" name="sabun" id="sabun" />
		</div>
		<div>
			<label for="file">file</label>
			<input type="file" name="file" id="file" />
		</div>
		<div>
			<input type="submit" value="업로드" />
		</div>
	</form>
</body>
</html>