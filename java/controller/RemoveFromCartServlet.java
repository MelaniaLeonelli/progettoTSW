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

@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCartServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cf = request.getParameter("cf");
		String pcode = request.getParameter("pcode");
		
		ContieneDAO cDAO = new ContieneDAO();
		CarrelloDAO carrDAO = new CarrelloDAO();
		try {
			cDAO.removeFromCart(cf, pcode);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		System.out.println(cf + " ha rimosso " + pcode);
		ArrayList<Contiene> c = null;
		try {
			c = carrDAO.getCart(cf);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		request.setAttribute("cf", c);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
