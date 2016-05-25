<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp" />
<h3>Informe os dados da conta a ser creditada</h3>
<form action="TransferenciaController" method="post">
	<table>
		<tr>
			<td>Numero da Conta:</td>
			<td><input type="text" name="txtNumeroConta" size="20">
		</tr>
		<tr>
			<td>Nome do Titular:</td>
			<td><input type="text" name="txtTitular" size="20">
		</tr>
		<tr>
			<td>Valor:</td>
			<td><input type="number" name="txtValor" size="20">
		</tr>
		<tr>
			<td>Descrição:</td>
			<td><input type="text" name="txtDescricao" size="20">
		</tr>
		<tr>
			<td><input type="submit" name="cmd" value="Transferir" ></td>
			<td><input type="submit" name="cmd" value="Cancela" ></td>
		</tr>
	</table>
</form>