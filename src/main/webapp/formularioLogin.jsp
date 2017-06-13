<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tagsAkira"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Formulario</title>
</head>
<body>
	<form action="usuController" method="post">
		<table>
			<tbody>
				<tr>
					<td>Login</td>
					<td><input type="text" name="login" autofocus="autofocus"
						required="" /></td>
				</tr>
				<tr>
					<td>Senha</td>
					<td><input type="text" name="senha" required="" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Entrar" /></td>
				</tr>
				<tr>
					<td></td>
					<td><tagsAkira:msgLoginSenha /></td>
				</tr>
			</tbody>
		</table>
	</form>


</body>
</html>