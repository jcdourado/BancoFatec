<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Banco Fatec - BFZL</title>
<meta charset="UTF-8" >
<meta name="viewport" content="width=device-width" >
<link href="estilos.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<header class="cabecalho">
		<h1 class="cabecalho--titulo">Banco Fatec - BFZL</h1>
		<p class="cabecalho--mensagem"><% if(request.getAttribute("MENSAGEM") != null) out.print(request.getAttribute("MENSAGEM")); %></p>
		<p class="cabecalho-cliente"><%	if(session.getAttribute("USERID") != null){ 
											String msg = (String) session.getAttribute("USERID");
											out.print(msg);
										    session.setAttribute("USERID",null);
										 } else {out.print("NÃO LOGADO"); } %></p>
	</header>

