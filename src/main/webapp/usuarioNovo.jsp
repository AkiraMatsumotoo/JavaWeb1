<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tagsAkira"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tagsAkira:usuValido />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adiciona novo usuario</title>
</head>
<link rel="stylesheet" type="text/css" href="css/styles2.css">
<script src="js/funcoes.js"></script>
<body>
	<div id="todoSite" align="center">
		<div id="cabecalho">cabecalho</div>
		<div id="menus"><jsp:include page="menus.jsp" /></div>
		<div id="central">
			<form action="UsuarioServlet" method="post">
				<table>
					<tr>
						<td>Nome</td>
						<td><input type="text" name="nome" required="" /></td>
					</tr>
					<tr>
						<td>Login</td>
						<td><input type="text" name="login" required="" /></td>
					</tr>
					<tr>
						<td>Senha</td>
						<td><input type="text" name="senha" required="" id="senha" /></td>
					</tr>
					<tr>
						<td>Repetir Senha</td>
						<td><input type="text" name="senha1" oninput="repitaSenha(this)" required="" /></td>
					</tr>
					<tr>
						<td>Nivel</td>
						<td><input type="number" min="1" max="3" name="nivel" required="" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Salvar" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="rodape"><jsp:include page="rodape.jsp" /></div>
	</div>
</body>