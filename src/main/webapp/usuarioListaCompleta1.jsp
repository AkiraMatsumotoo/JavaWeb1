<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tagsAkira"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%-- <tagsAkira:usuValido /> --%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de login</title>
</head>
<link rel="stylesheet" type="text/css" href="css/styles2.css">
<body>

	<table>
		<tr>
			<th width="20">ID</th>
			<th width="150">Nome</th>
			<th width="20">Login</th>
			<th width="20">Senha</th>
			<th width="20">nivel</th>
		</tr>
		<c:forEach items="${listaCompleta}" var="usuarios">
			<tr>
				<td>${usuarios.id}</td>
				<td>${usuarios.nome}</td>
				<td>${usuarios.login}</td>
				<td>${usuarios.senha}</td>
				<td>${usuarios.nivel}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>