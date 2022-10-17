package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarrelloDAO;
import model.Contiene;
import model.ContieneDAO;
import model.ProdottoDAO;

@WebServlet("/AddToDBServlet")
public class AddToDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToDBServlet() {
        super();

    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pcode = request.getParameter("pcode");
		String name = request.getParameter("name");
		String categoria = request.getParameter("categoria");
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		String marca = request.getParameter("marca");
		double costo = Double.parseDouble(request.getParameter("costo"));
		String img = request.getParameter("img");
		String genre = request.getParameter("genere");
		
		System.out.println("Hai inserito il prodotto " + marca + name + "(" + pcode + ")" + " nel database.");
		ProdottoDAO pDAO = new ProdottoDAO();
		
		try {
			pDAO.addProduct(pcode, name, categoria, quantita, marca, costo, img, genre);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("addToDBResult.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
