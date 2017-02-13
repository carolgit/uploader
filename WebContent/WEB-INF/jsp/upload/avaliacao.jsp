<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Upload Planilha</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
		integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
		crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
<!-- 	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js" /> -->
<style>
.planilha{
	display: none;
}
</style>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<b>Forma de preechimento</b>
		</div>
		<div class="panel-body">
			<div class="col-lg-6">
				<div class="input-group" onclick="preechimeto()">
					<span class="input-group-addon"> <input type="radio"
						name="preenchimento" checked="checked" aria-label="..."
						value="completo">
					</span> <label class="form-control">Formulário Completo</label>
				</div>
				<div class="input-group" onclick="preechimeto()">
					<span class="input-group-addon"> <input type="radio"
						name="preenchimento" value="simples" aria-label="...">
					</span> <label class="form-control">Formulário Simplicado</label>
				</div>
				<div class="input-group" onclick="preechimeto()">
					<span class="input-group-addon"> <input type="radio"
						name="preenchimento" value="planilha" aria-label="...">
					</span> <label class="form-control">Upload de Planilha</label>
				</div>
				<!-- /input-group -->
			</div>
		</div>
	</div>
	<div class="completo">
		Teste1
		<div class="simples">Teste2</div>
	</div>
	<div class="planilha">
		<form action="${linkTo[UploadController].upload}" method="post" enctype="multipart/form-data">
			<input type="file" name="file" value="${file}">
			<button type="submit">Enviar</button>
		</form>
	</div>

	<script>
	function preechimeto(){
		if ($('input[name="preenchimento"]:checked').val() === "completo") {
			$(".completo").css("display", "block");
			$(".simples").css("display", "block");
			$(".planilha").css("display", "none");
		} else if ($('input[name="preenchimento"]:checked').val() === "simples") {
			$(".completo").css("display", "block");
			$(".simples").css("display", "none");
			$(".planilha").css("display", "none");
		} else if ($('input[name="preenchimento"]:checked').val() === "planilha") {
			$(".completo").css("display", "none");
			$(".planilha").css("display", "block");
		}
	}
	</script>
</body>
</html>
