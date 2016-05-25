<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("PERFIL") == null){
		response.sendRedirect("/BFZL/login.jsp");
	} %>
<jsp:include page="cabecalho.jsp" />
<h3>Menu Principal</h3>
<a href="extrato.jsp">Extrato</a>
<a href="saque.jsp">Saque</a>
<a href="transferencia.jsp">Transferencia</a>
<a href="pagamento.jsp">Pagamento</a>
