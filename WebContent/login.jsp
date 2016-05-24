<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp" />
<h3>Digite seu usuário e senha para acessar o banco</h3>
<form action="/LoginController" method="post">
	<table>
		<tr>
			<td>Usuario:</td>
			<td><input type="text" name="txtUsuario" size="20">
		</tr>
		<tr>
			<td>Senha:</td>
			<td><input type="password" name="txtSenha" size="20">
		</tr>
		<tr>
			<td><input type="submit" name="cmd" value="Login" ></td>
			<td><input type="submit" name="cmd" value="Cancela" ></td>
		</tr>
	</table>
</form>