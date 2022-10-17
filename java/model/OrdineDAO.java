package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DriverManagerConnectionPool;

public class OrdineDAO {
	
	public static String URL = "jdbc:mysql://localhost:3306/gamemoving";
	public static String USER = "sisi";
	public static String PASS = "password";

	public ArrayList<Ordine> getOrders(String cf) throws ClassNotFoundException{
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT CodOrdine, Data, Ora, ImportoTotale, CodFiscale FROM Ordine WHERE Ordine.CodFiscale = ?");
			stmt.setString(1, cf);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Ordine or = new Ordine();
				or.setCodOrdine(rs.getInt("CodOrdine"));
				or.setData(rs.getString("Data"));
				or.setOra(rs.getString("Ora"));
				or.setImportoTotale(Double.parseDouble(rs.getString("ImportoTotale")));
				or.setCF(rs.getString("CodFiscale"));
				ordini.add(or);
			}
			return ordini;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Ordine> getAllOrders() throws ClassNotFoundException{
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT CodOrdine, Data, Ora, CodFiscale FROM Ordine");
			ResultSet rs;
			rs = stmt.executeQuery();
			while(rs.next()) {
				Ordine or = new Ordine();
				or.setCodOrdine(rs.getInt("CodOrdine"));
				or.setData(rs.getString("Data"));
				or.setOra(rs.getString("Ora"));
				or.setCF(rs.getString("CodFiscale"));
				ordini.add(or);
			}
			return ordini;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public Ordine getOrderByCode(int CodOrdine) throws ClassNotFoundException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT CodOrdine, Data, Ora, ImportoTotale, CodFiscale FROM Ordine WHERE Ordine.CodOrdine = ?");
			stmt.setInt(1, CodOrdine);
			ResultSet rs;
			rs = stmt.executeQuery();
			Ordine or = new Ordine();
			while(rs.next()) {
				or.setCodOrdine(rs.getInt("CodOrdine"));
				or.setData(rs.getString("Data"));
				or.setOra(rs.getString("Ora"));
				or.setImportoTotale(Double.parseDouble(rs.getString("ImportoTotale")));
				or.setCF(rs.getString("CodFiscale"));
			}
			return or;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public void order(int CodOrdine, String cf, String data, String ora, double importoTotale) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO ordine VALUES (?, ?, ?, ?, ?)");
		stmt.setInt(1, CodOrdine);
		stmt.setString(2, data);
		stmt.setString(3, ora);
		stmt.setDouble(4, importoTotale);
		stmt.setString(5, cf);
		stmt.executeUpdate();
	}
	
	public int getLatestOrder() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT CodOrdine FROM ordine WHERE CodOrdine=(SELECT max(CodOrdine) FROM ordine)");
		ResultSet rs;
		rs = stmt.executeQuery();
		 try {
				while(rs.next()) {
				int latestOrder;
				latestOrder = rs.getInt("CodOrdine");
				return latestOrder;
				}
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
			return 0;
	}
	
}
