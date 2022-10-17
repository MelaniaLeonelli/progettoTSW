<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList, model.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="logo.ico">
<link rel="stylesheet" href="../css/styles.css">
<link rel="stylesheet" href="../css/dropdown.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/loginstyle.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Modifica Prodotto</title>
</head>
<body id="corpo">
	<%
		Prodotto p = (Prodotto) request.getAttribute("product");%>

	<%String email = (String) session.getAttribute("email");
	  String name = (String) session.getAttribute("name");
	  Boolean role = (Boolean) session.getAttribute("adminRoles");
	 %>

	<jsp:include page="headerEditPage.jsp"></jsp:include>

	<main class="form-signin w-100 m-auto">

		<form action="ProductUpdateServlet" id="editForm">

			<input type="text" class="form-control" id="pcode" name="pcode"
				onblur="blurInput()" readonly placeholder="<%=p.getCodprodotto()%>"
				value="<%=p.getCodprodotto()%>"> <labelfor "nome"><b>Nome</b>:</label>
	<div class="form-floating" id="formdiv" contentEditable="true">
		<input type="text" class="form-control" id = "name" type = "text" name = "name" onblur = "blurInput()" readonly placeholder="<%=p.getNome()%>" value="<%=p.getNome()%>">
	</div>
	<label for "nome"><b>Categoria</b>:</label>
	<div class="form-floating" contentEditable="true" id="formdiv">
		<input type="text" class="form-control" id = "category" type = "text" name = "category" onblur = "blurInput()" readonly placeholder = "<%=p.getCategoria()%>" value="<%=p.getCategoria()%>">
	</div>
	<label for "nome"><b>Quantità</b>:</label>
	<div class="form-floating" contentEditable="true" id="formdiv">
		<input type="text" class="form-control" id = "quantity" type = "text" name = "quantity" onblur = "blurInput()" placeholder = "<%=p.getQuantita()%>" value="<%=p.getQuantita()%>">
	</div>
	<label for "nome"><b>Marca</b>:</label>
	<div class="form-floating" contentEditable="true" id="formdiv">
		<input type="text" class="form-control" id = "brand" type = "text" name = "brand" onblur = "blurInput()" placeholder = "<%=p.getMarca()%>" value="<%=p.getMarca()%>">
	</div>
	<label for "nome"><b>Costo</b>:</label>
	<div class="form-floating" contentEditable="true" id="formdiv">
		<input type="text" class="form-control" id = "cost" type = "text" name = "cost" onblur = "blurInput()" placeholder = "<%=p.getCosto()%>" value="<%=p.getCosto()%>">
	</div>
	<label for "nome"><b>Genere</b>:</label>
	<div class="form-floating" contentEditable="true" id="formdiv">
		<input type="text" class="form-control" id = "genre" type = "text" name = "genre" onblur = "blurInput()" placeholder = "<%=p.getGenere()%>" value="<%=p.getGenere()%>">
	</div>
	
	<button id = "editBtn" class="w-100 btn btn-lg btn-primary" type="submit">Modifica il prodotto</button>
  </form>

	</main>

	<jsp:include page="editFooter.html"></jsp:include>

	<script>
	const button = document.getElementById('button');
	const cart = document.getElementById('cart');
	const text = document.getElementById('text');
	
	button.onclick = function() {
	  if (!document.getElementsByClassName('cartAnimation').length) {
	    cart.classList.add('cartAnimation');
	    text.classList.add('textAnimation');
	    button.classList.add('buttonAnimation');
	  } else {
	    cart.classList.remove('cartAnimation');
	    text.classList.remove('textAnimation');
	    button.classList.remove('buttonAnimation');
	  }
	}	
</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/ajaxsearch.js"></script>
</body>
</html>