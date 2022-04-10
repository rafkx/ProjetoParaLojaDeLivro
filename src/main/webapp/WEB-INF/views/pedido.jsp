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

<section id="form-contato"  class="pad3y">
        <h1> Atualizando o seu pedido</h1>      
    <form action="PedidoServlet" method="POST"> 
		<div class="nome">
            <label for="nome">Nome</label> 
            <input type="text" name="nome" id="nome" value="${pedido.nome}">
            <input type="hidden" name="id" value="${pedido.id}">
        </div>
        <div class="endereco">
            <label for="endereco">Endereço</label> 
            <input type="text" name="end" id="end" value="${pedido.end}">
        </div>
		<div class="pedido">
            <label for="pedido">Pedido</label> 
            <p>Livros que você quer na sua Bookshelf :)</p>
            <textarea type="text" name="book" id="book">${pedido.book}</textarea>
        </div>
	<button type="submit">Enviar </button>
	</form>
 </section>

</body>
</html>