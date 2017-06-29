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
	<div id="todoSite" align="center">
		<div id="cabecalho">cabecalho</div>
		<div id="menus"><jsp:include page="menus.jsp" /></div>
		<div id="central">
			<table>
				<tr>
					<th><a href="usuarioNovo.jsp">Novo Usuario</a></th>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<form action="UsuarioServlet" method="get">
							<input type="text" name="nome"/>
							<input type="submit" name="acao" value="pesquisar"/>
						</form>
					</td>
				</tr>
			</table>

			<table>
				<tr>
					<th width="20">ID</th>
					<th width="150">Nome</th>
					<th width="20">Login</th>
					<th width="20">Senha</th>
					<th width="20">nivel</th>
					<th width="5">Excluir</th>
					<th width="5">Editar</th>
				</tr>
				<c:forEach items="${pesquisa}" var="usuarios">
					<tr>
						<td>${usuarios.id}</td>
						<td>${usuarios.nome}</td>
						<td>${usuarios.login}</td>
						<td>${usuarios.senha}</td>
						<td>${usuarios.nivel}</td>
						<td><a
							href="usuarioAltera.jsp?id=${usuarios.id}&nome=${usuarios.nome}&login=${usuarios.login}&senha=${usuarios.senha}&nivel=${usuarios.nivel}">Editar</a></td>
						<td><a href="UsuarioServlet?acao=excluir&id=${usuarios.id}">Excluir</a></td>
					</tr>
				</c:forEach>
			</table>
			<%
				int totalPaginas = (int) request.getAttribute("totalDePaginas");
				for (int i = 1; i <= totalPaginas; i++) {
			%>
			<a href="UsuarioServlet?numeroPagina=<%=i%>"><%=i%></a>
			<%
				}
			%>
		</div>

		<div id="rodape"><jsp:include page="rodape.jsp" /></div>
	</div>
</body>
</html>