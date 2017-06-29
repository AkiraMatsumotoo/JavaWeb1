<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tagsAkira"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de login</title>
</head>
<link rel="stylesheet" type="text/css" href="css/styles2.css">
<body>


	<form action="UsuarioServlet2" method="get">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>Nome</td>
				<td><input type="text" name="nome" /></td>
			</tr>
			<tr>
				<td>Login</td>
				<td><input type="text" name="login" /></td>
			</tr>
			<tr>
				<td>Senha</td>
				<td><input type="text" name="senha" /></td>
			</tr>
			<tr>
				<td>Nivel</td>
				<td><input type="text" name="nivel" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="acao" value="salvar" /></td>
			</tr>

		</table>
	</form>


</body>
</html>