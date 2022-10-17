package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AcquistoDAO;
import model.CarrelloDAO;
import model.Contiene;
import model.ContieneDAO;
import model.Ordine;
import model.OrdineDAO;
import model.Prodotto;
import model.ProdottoDAO;

@WebServlet("/ExecuteOrderServlet")
public class ExecuteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteOrderServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cf = request.getParameter("cf");
		int latest = 0;
		double tot = 0;
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
		CarrelloDAO cDAO = new CarrelloDAO();
		OrdineDAO oDAO = new OrdineDAO();
		ContieneDAO coDAO = new ContieneDAO();
		AcquistoDAO aDAO = new AcquistoDAO();
		ProdottoDAO pDAO = new ProdottoDAO();

		ArrayList<Contiene> cart = new ArrayList<Contiene>();
		try {
			cart = cDAO.getCart(cf);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			tot = coDAO.getTotal(cf);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		try {
			latest = oDAO.getLatestOrder();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		latest++;
		
		try {
			oDAO.order(latest, cf, date.format(formatterDate), time.format(formatterTime), tot);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		int i = 0;
		while(i < cart.size()) {
			int cod = latest;
			double prezzo;
			Prodotto p = new Prodotto();
			try {
				p = pDAO.getProduct(cart.get(i).getCodProdotto());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			prezzo = p.getCosto();
			System.out.println(prezzo);
			try {
				aDAO.addAcquisto(cod, cart.get(i).getCodProdotto(), prezzo);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			i++;
		}
		
		i = 0;
		while(i < cart.size()) {
			try {
				pDAO.rimuoviUnita(cart.get(i).getCodProdotto());
			} catch (ClassNotFoundException | SQLException e) {
	
				e.printStackTrace();
			}
			i++;
		}
	
		try {
			cDAO.emptyBasket(cf);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		
		Ordine o = new Ordine();
		try {
			o = oDAO.getOrderByCode(latest);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		System.out.println(cf + "ha effettuato l'ordine" + latest);
		
		request.setAttribute("CodOrdine", o);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ordineeffettuato.jsp");
		dispatcher.forward(request, response);
	}
	
	/**d
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
