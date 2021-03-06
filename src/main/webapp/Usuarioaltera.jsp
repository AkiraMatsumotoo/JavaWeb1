<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tagsAkira"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<tagsAkira:usuValido />
<script src="js/funcoes.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de login</title>
</head>
<link rel="stylesheet" type="text/css" href="css/styles2.css">
<body>
	<div id="todoSite" align="center">
		<div id="cabecalho">cabecalho</div>
		<div id="menus"><jsp:include page="menus.jsp" /></div>
		<div id="central">
			<form action="UsuarioServlet" method="get">
				<table>
					<tr>
						<td>ID</td>
						<td><input type="text" name="id" value="${param.id}"
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td>Nome</td>
						<td><input type="text" name="nome" value="${param.nome}" /></td>
					</tr>
					<tr>
						<td>Login</td>
						<td><input type="text" name="login" value="${param.login}" /></td>
					</tr>
					<tr>
						<td>Senha</td>
						<td><input type="text" name="senha" id="senha" /></td>
					</tr>
					<tr>
						<td>Repetir Senha</td>
						<td><input type="text" name="senha1"
							oninput="repitaSenha(this)" required="" /></td>
					</tr>
					<tr>
						<td>Nivel</td>
						<td><input type="text" name="nivel" value="${param.nivel}" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" name="acao" value="alterar" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="rodape"><jsp:include page="rodape.jsp" /></div>
	</div>
</body>