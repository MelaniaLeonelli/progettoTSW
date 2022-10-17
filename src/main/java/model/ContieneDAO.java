package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContieneDAO {
	
	public static String URL = "jdbc:mysql://localhost:3306/gamemoving";
	public static String USER = "sisi";
	public static String PASS = "password";
	
	public void addToCart(String cf, String codProdotto, int quantita, double importoTotale) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO contiene VALUES(?, '1', ?, ?);");
		stmt.setString(1, codProdotto);
		stmt.setDouble(2, importoTotale);
		stmt.setString(3, cf);
		System.out.println("stmt:" + stmt);
		stmt.executeUpdate();
	}
	
	public void removeFromCart(String cf, String codProdotto) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("DELETE FROM contiene WHERE CodFiscale = ? AND codProdotto = ?");
		stmt.setString(1, cf);
		stmt.setString(2, codProdotto);
		stmt.executeUpdate();
	}
	
	public Double getTotal(String cf) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT SUM(ImportoTotale) FROM contiene WHERE CodFiscale = ?");
		stmt.setString(1, cf);
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
			double tot = 0.0;
			double iva = 0.22;
			tot = Double.parseDouble(rs.getString("sum(ImportoTotale)"));
			tot += tot * iva;
			return tot;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0.0;
	}
	
}
