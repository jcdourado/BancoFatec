<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Lancamento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp" />
<h3>Informe os dados da conta a ser paga</h3>
<form action="ExtratoController" method="post">
	<table>
		<tr>
			<td>Data Início:</td>
			<td><input type="date" name="txtDataInicio">
		</tr>
		<tr>
			<td>Data Término:</td>
			<td><input type="date" name="txtDataFim">
		</tr>
		<tr>
			<td><input type="submit" name="cmd" value="Mostrar Extrato" ></td>
			<td><input type="submit" name="cmd" value="Cancela" ></td>
		</tr>
	</table>
	<% if(request.getAttribute("EXTRATO") != null){
			List<Lancamento> lancamentos = (List<Lancamento>) request.getAttribute("EXTRATO");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	%>
		<h3>Lançamentos no periodo de <% out.print((String) session.getAttribute("dtInicio")); %> à <% out.print((String) session.getAttribute("dtFim")); %></h3>
		<table>
			<tr>
				<th>Id</th>
				<th>Tipo</th>
				<th>Data</th>
				<th>Valor</th>
				<th>Descrição</th>
				<th>Saldo Resultante</th>
			</tr>
			<% 
			for(Lancamento l : lancamentos){ %>
				<tr>
					<td><%=l.getId() %></td>
					<td><%=l.getTipo() %></td>
					<td><%=sdf.format(l.getDataLancamento()) %></td>
					<td><%=l.getValor() %></td>
					<td><%=l.getDescricao() %></td>
					<td><%=l.getSaldoPosterior() %></td>
				</tr>
			<% } %>
		</table>
	<% } %>
</form>