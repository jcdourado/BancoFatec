<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp" />
<h3>Informe o valor a ser sacado da Conta</h3>
<form action="/SaqueController">
	<table>
		<tr>
			<td>Valor:</td>
			<td><input type="text" name="txtValor" size="20">
		</tr>
		<tr>
			<td>Descrição:</td>
			<td><input type="text" name="txtDescricao" size="20">
		</tr>
		<tr>
			<td><input type="submit" name="cmd" value="Saque" ></td>
			<td><input type="submit" name="cmd" value="Cancela" ></td>
		</tr>
	</table>
</form>