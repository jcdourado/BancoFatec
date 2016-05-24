<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp" />
<h3>Informe os dados da conta a ser paga</h3>
<form action="/PagamentoController">
	<table>
		<tr>
			<td>Numero Boleto:</td>
			<td><input type="text" name="txtBoleto" size="20">
		</tr>
		<tr>
			<td>Data Vencimento:</td>
			<td><input type="date" name="txtVencimento">
		</tr>
		<tr>
			<td>Cedente:</td>
			<td><input type="text" name="txtCedente" size="20">
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
			<td><input type="submit" name="cmd" value="Efetuar Pagamento" ></td>
			<td><input type="submit" name="cmd" value="Cancela" ></td>
		</tr>
	</table>
</form>