

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Planilha</title>
</head>
<body>
	<form action="${linkTo[UploadController].upload}" method="post" enctype="multipart/form-data">
		<input type="file" name="file" value="${file}">
		<button type="submit">Enviar</button>
	</form>
</body>
</html>

