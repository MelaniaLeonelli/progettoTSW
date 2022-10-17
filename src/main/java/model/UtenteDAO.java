package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DriverManagerConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtenteDAO {
	
	public static String URL = "jdbc:mysql://localhost:3306/gamemoving";
	public static String USER = "sisi";
	public static String PASS = "password";

	public void register(String cf, String s, String n, String e, String p) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO utente VALUES (?, ?, ?, ?, SHA2(CONCAT(?, 'criptalo'), 512), 0)");
		stmt.setString(1, cf);     
		stmt.setString(2, s);
		stmt.setString(3, n);     
		stmt.setString(4, e); 
		stmt.setString(5, p);
		stmt.executeUpdate();
	}
	
	public Integer login(String e, String p) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT Email, Password, IsAdmin FROM utente WHERE utente.Email = ? AND utente.Password = SHA2(CONCAT(?, 'criptalo'), 512)");
			stmt.setString(1, e);     
			stmt.setString(2, p);
			ResultSet rs = stmt.executeQuery();
			System.out.println("Utente: " + rs);
			try {
				while(rs.next()) {
					if(Integer.parseInt(rs.getString("utente.IsAdmin")) > 0) {
						return 1;
					}
					else{
						return 2;
					}
						
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return 3;
	}
	
	public Utente getUserData(String e, String p) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT CodFiscale, Nome, Cognome FROM utente WHERE utente.Email = ?");
		stmt.setString(1, e);
		ResultSet rs = stmt.executeQuery();
		Utente u = new Utente();
		try {
			while(rs.next()) {
				u.setCF(rs.getString("CodFiscale"));
				u.setNome(rs.getString("Nome"));
				u.setCognome(rs.getString("Cognome"));
			}
		} catch (SQLException e1) {
			return null;
		}
		return u;
	}
	
	public Utente getUserByCF(String cf) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT CodFiscale, Nome, Cognome FROM utente WHERE utente.CodFiscale = ?");
		stmt.setString(1, cf);
		ResultSet rs = stmt.executeQuery();
		Utente u = new Utente();
		try {
			while(rs.next()) {
				u.setCF(rs.getString("CodFiscale"));
				u.setNome(rs.getString("Nome"));
				u.setCognome(rs.getString("Cognome"));
			}
		} catch (SQLException e1) {
			return null;
		}
		return u;
	}

	public Boolean alreadyExist(String e) throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
		
			stmt = con.prepareStatement("SELECT Email FROM utente WHERE utente.Email = ?");
			stmt.setString(1, e);
			ResultSet rs = stmt.executeQuery();
			try {
				while(rs.next()) {
					return true;
				}
			} catch (SQLException e1) {
				return false;
			}
			return false;
		}
	
	
}
