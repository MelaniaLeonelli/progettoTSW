<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="searchbar">

	<form action="SearchServlet" method="post" id="searchBar">
		<input type="text" onblur="hideSearchResult()" autocomplete="off"
			id="ajaxsearch"
			class="form-control form-control-dark text-white bg-dark"
			placeholder="Cerca..." name="cerca">
		<div id="searchResult" style="display: none;"></div>
	</form>

	<%String email = (String) session.getAttribute("email");
	 if (email != null) { %>
	<button type="button" class="btn btn-warning primary-button ordcart"
		id="cartBtn"
		onclick="window.location.href='CartServlet?cf=<%=session.getAttribute("cf")%>'">
		<img src="cart.png" height="25" width="30" />
	</button>
	<button type="button" class="btn btn-warning primary-button ordcart"
		id="orderBtn"
		onclick="window.location.href='OrderServlet?cf=<%=session.getAttribute("cf")%>'">Ordini</button>
	<% } %>
</div>