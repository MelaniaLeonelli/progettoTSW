<!DOCTYPE html>
<html>
<head>
<%@ page import="model.*"%>
<meta charset="ISO-8859-1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>

<link rel="icon" type="image/x-icon" href="logo.ico">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/dropdown.css">
<title>Homepage</title>
</head>
<body>

	<%String email = (String) session.getAttribute("email");
	String cf = (String) session.getAttribute("cf");
	  String name = (String) session.getAttribute("name");
	  Boolean role = (Boolean) session.getAttribute("adminRoles");
	 if (email == null) { %>
	<jsp:include page="headerGuest.jsp"></jsp:include>

	<% } 
	 else if(role == Boolean.TRUE)
	 {%>
	<jsp:include page="headerAdmin.jsp"></jsp:include>
	<% }
	 else { %>
	<jsp:include page="headerUtente.jsp"></jsp:include>
	<%} %>

	<%
	ProdottoDAO pDAO = new ProdottoDAO();
	
	Prodotto p1 = new Prodotto();
	Prodotto p2 = new Prodotto();
	Prodotto p3 = new Prodotto();
	Prodotto p4 = new Prodotto();
	Prodotto p5 = new Prodotto();
	Prodotto p6 = new Prodotto();
	Prodotto p7 = new Prodotto();
	Prodotto p8 = new Prodotto();
	
	p1 = pDAO.getProduct("00000001");
	p2 = pDAO.getProduct("00000003");
	p3 = pDAO.getProduct("00000040");
	p4 = pDAO.getProduct("00000066");
	p5 = pDAO.getProduct("00000014");
	p6 = pDAO.getProduct("00000037");
	p7 = pDAO.getProduct("00000029");
	p8 = pDAO.getProduct("00000007");
	%>


	<jsp:include page="searchbar.jsp"></jsp:include>

	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top" src="<%=p1.getImmagine()%>" alt="...">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%=p1.getNome() + " " + p1.getCategoria()%></h5>
								<!-- Product price-->
								$<%=p1.getCosto()%>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark product" id="btnView"
									href="ProductPageServlet?pcode=<%=p1.getCodprodotto()%>">Visualizza
									prodotto</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->

						<!-- Product image-->
						<img class="card-img-top" src="<%=p2.getImmagine()%>" alt="...">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%=p2.getNome() + " " + p2.getCategoria()%></h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								$<%=p2.getCosto() %>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto product"
									href="ProductPageServlet?pcode=<%=p2.getCodprodotto()%>">Visualizza
									prodotto</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->

						<!-- Product image-->
						<img class="card-img-top" src="<%=p3.getImmagine()%>" alt="...">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%=p3.getNome() + " " + p3.getCategoria() %></h5>
								<!-- Product price-->
								$<%=p3.getCosto() %>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto product"
									href="ProductPageServlet?pcode=<%=p3.getCodprodotto()%>">Visualizza
									prodotto</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top" src="<%=p4.getImmagine()%>" alt="...">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%=p4.getNome() + " " + p4.getCategoria()%></h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								$<%=p4.getCosto()%>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto product"
									href="ProductPageServlet?pcode=<%=p4.getCodprodotto()%>">Visualizza
									prodotto</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->

						<!-- Product image-->
						<img class="card-img-top" src="<%=p5.getImmagine()%>" alt="...">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%=p5.getNome() + " " + p5.getCategoria() %></h5>
								<!-- Product price-->
								$<%=p5.getCosto()%>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto product"
									href="ProductPageServlet?pcode=<%=p5.getCodprodotto()%>">Visualizza
									prodotto</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top" src="<%=p6.getImmagine()%>" alt="...">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%= p6.getNome() + " " + p6.getCategoria()%></h5>
								<!-- Product price-->
								$<%=p6.getCosto() %>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto product"
									href="ProductPageServlet?pcode=<%=p6.getCodprodotto()%>">Visualizza
									prodotto</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->

						<!-- Product image-->
						<img class="card-img-top" src="<%=p7.getImmagine()%>" alt="...">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%=p7.getNome() + " " + p7.getCategoria() %></h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								$<%=p7.getCosto() %>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto product"
									href="ProductPageServlet?pcode=<%=p7.getCodprodotto()%>">Visualizza
									prodotto</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top" src="<%=p8.getImmagine()%>" alt="...">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%=p8.getNome() %></h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								$<%=p8.getCosto() %>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto product"
									href="ProductPageServlet?pcode=<%=p8.getCodprodotto()%>">Visualizza
									prodotto</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="footer.html"></jsp:include>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/ajaxsearch.js"></script>

</body>
</html>