package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InfoUtente;
import model.Utente;
import model.UtenteDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cf = request.getParameter("CodFiscale");
		
		System.out.println(email + ", " + password);
		UtenteDAO uDAO = new UtenteDAO();
		RequestDispatcher dispatcher;
		
				try 
				{
					if (uDAO.login(email, password) == 1)
					{
						request.getSession().setAttribute("adminRoles", Boolean.TRUE);
						request.getSession().setAttribute("email", email);
						Utente u = uDAO.getUserData(email, password);
						request.getSession().setAttribute("name", u.getNome());
						request.getSession().setAttribute("cf", u.getCF());
						dispatcher = request.getRequestDispatcher("index.jsp");
						dispatcher.forward(request, response);
					}
					
					else if(uDAO.login(email, password) == 2)
					{
						request.getSession().setAttribute("adminRoles", Boolean.FALSE);
						request.getSession().setAttribute("email", email);
						Utente u = uDAO.getUserData(email, password);
						request.getSession().setAttribute("name", u.getNome());
						request.getSession().setAttribute("cf", u.getCF());
						dispatcher = request.getRequestDispatcher("index.jsp");
						dispatcher.forward(request, response);
					}
					
					else if(uDAO.login(email, password) == 3)
					{
						request.getSession().setAttribute("nonRegistrato", Boolean.TRUE);
						dispatcher = request.getRequestDispatcher("loginResult.jsp");
						dispatcher.forward(request, response);
					}
					
					
			  }catch (ClassNotFoundException | SQLException | ServletException | IOException e) 
			   {
				  e.printStackTrace();
			   }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
