package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ordine;
import model.OrdineDAO;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cf = request.getParameter("cf");
		String pcode = request.getParameter("pcode");
		
		OrdineDAO oDAO = new OrdineDAO();
		ArrayList<Ordine> o = null;
		try {
			o = oDAO.getOrders(cf);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		request.setAttribute("cf", o);
		RequestDispatcher dispatcher = request.getRequestDispatcher("orders.jsp");
		dispatcher.forward(request, response);
	}
	
	/**d
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
