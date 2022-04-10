<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head lang="ptbr">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Bem vindo a nossa Bookstore!">
<meta name="keywords" content="livros, books, ler">
<link rel="stylesheet" href="css/style.css">
	<title>Bookshelf</title>
</head>
<body>
<header> 
	<nav id="navegacao">
		<div class="conteiner">
			<h1>Home</h1>	
		<ul>			
			<li><a href="index.html">Pedidos</a></li>
		</ul>
		</div>
	</nav>
</header>

<section id="lista-pedido" class="pad3y">
	<h1 class="cabecalho-lista-pedido"> Lista dos Pedidos</h1>
	<table class="tabela-pedido">
		<thead>
			<tr>
			<td>Nome</td>
			<td>Endereço</td>
			<td>Pedido</td>
			<td colspan="2" id="coluna-acao">Ação</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var ="pedido" items="${pedidos}">
			<tr>
				<td>${pedido.nome}</td>
				<td>${pedido.end}</td>
				<td>${pedido.book}</td>
				<td><a href="PedidoServlet?acao=editar&id=${pedido.id}">Editar</a></td>
				<td><a href="PedidoServlet?acao=remover&id=${pedido.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>

</body>
</html>