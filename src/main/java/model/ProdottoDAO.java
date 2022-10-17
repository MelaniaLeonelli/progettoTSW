package model;
import java.sql.*;
import java.util.ArrayList;

import controller.DriverManagerConnectionPool;

public class ProdottoDAO {
	
	public static String URL = "jdbc:mysql://localhost:3306/gamemoving";
	public static String USER = "sisi";
	public static String PASS = "password";
	
	public ArrayList<Prodotto> doRetrieveByName(String nome) throws ClassNotFoundException{
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT nome, codprodotto, categoria, marca, costo, immagine, genere, quantita FROM prodotto WHERE prodotto.nome LIKE ?");
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Prodotto p = new Prodotto();
				p.setNome(rs.getString("nome"));
				p.setCodprodotto(rs.getString("codprodotto"));
				p.setCategoria(rs.getString("categoria"));
				p.setMarca(rs.getString("marca"));
				p.setCosto(Double.parseDouble(rs.getString("costo")));
				p.setImmagine(rs.getString("immagine"));
				p.setGenere(rs.getString("genere"));
				p.setQuantita(Integer.parseInt(rs.getString("quantita")));
				prodotti.add(p);
			}
			return prodotti;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Prodotto> doRetrieveByCategoria(String cat) throws ClassNotFoundException, SQLException{
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT nome, codprodotto, categoria, marca, costo, immagine, genere, quantita FROM prodotto WHERE prodotto.categoria LIKE ?");
			stmt.setString(1, "%" + cat + "%");
			System.out.println("stmt:" + stmt);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Prodotto p = new Prodotto();
				p.setNome(rs.getString("nome"));
				p.setCodprodotto(rs.getString("codprodotto"));
				p.setCategoria(rs.getString("categoria"));
				p.setMarca(rs.getString("marca"));
				p.setCosto(Double.parseDouble(rs.getString("costo")));
				p.setImmagine(rs.getString("immagine"));
				p.setGenere(rs.getString("genere"));
				p.setQuantita(Integer.parseInt(rs.getString("quantita")));
				prodotti.add(p);
			}
			return prodotti;
	}
	
	public ArrayList<Prodotto> doRetrieveByBrand(String mar) throws ClassNotFoundException{
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT nome, codprodotto, categoria, marca, costo, immagine, genere, quantita FROM prodotto WHERE prodotto.marca LIKE %?%");
			stmt.setString(1, "%" + mar + "%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Prodotto p = new Prodotto();
				p.setNome(rs.getString("nome"));
				p.setCodprodotto(rs.getString("codprodotto"));
				p.setCategoria(rs.getString("categoria"));
				p.setMarca(rs.getString("marca"));
				p.setCosto(Double.parseDouble(rs.getString("costo")));
				p.setImmagine(rs.getString("immagine"));
				p.setGenere(rs.getString("genere"));
				p.setQuantita(Integer.parseInt(rs.getString("quantita")));
				prodotti.add(p);
			}
			return prodotti;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public void addProduct(String codProdotto, String nome, String categoria, int quantita, String marca, double costo, String immagine, String genere) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO prodotto VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		stmt.setString(1, codProdotto);     
		stmt.setString(2, nome);
		stmt.setString(3, categoria);     
		stmt.setInt(4, quantita); 
		stmt.setString(5, marca);
		stmt.setDouble(6, costo);     
		stmt.setString(7, immagine); 
		stmt.setString(8, genere);
		stmt.executeUpdate();
		
	}
	
	public void deleteProduct(String codProdotto) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("DELETE FROM prodotto WHERE codProdotto = ?");
		stmt.setString(1, codProdotto);
		stmt.executeUpdate();
		
	}
	
	public Prodotto getProduct(String codProdotto) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT nome, codprodotto, categoria, marca, costo, immagine, genere, quantita FROM prodotto WHERE codProdotto = ?");
		stmt.setString(1, codProdotto);
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				Prodotto p = new Prodotto();
				p.setNome(rs.getString("nome"));
				p.setCodprodotto(rs.getString("codprodotto"));
				p.setCategoria(rs.getString("categoria"));
				p.setMarca(rs.getString("marca"));
				p.setCosto(Double.parseDouble(rs.getString("costo")));
				p.setImmagine(rs.getString("immagine"));
				p.setGenere(rs.getString("genere"));
				p.setQuantita(Integer.parseInt(rs.getString("quantita")));
				return p;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	public void rimuoviUnita(String codProdotto) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("UPDATE prodotto SET quantita = quantita - 1 WHERE codProdotto = ? AND quantita > 0");
		stmt.setString(1, codProdotto);
		stmt.executeUpdate();
	}
	
	public ArrayList<String> getProductCodes() throws SQLException, ClassNotFoundException {
		ArrayList<String> codes = new ArrayList<String>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT codprodotto FROM prodotto");
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()) {
				String s;
				s = rs.getString("codprodotto");
				codes.add(s);
			}
			return codes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateProduct(String codProdotto, String name, String category, int quantity, String brand, double cost, String genre) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("UPDATE prodotto SET nome = ?, categoria = ?, quantita = ?, marca = ?, costo = ?, genere = ? WHERE codprodotto = ?");
		stmt.setString(1, name);
		stmt.setString(2, category);
		stmt.setInt(3, quantity);
		stmt.setString(4, brand);
		stmt.setDouble(5, cost);
		stmt.setString(6, genre);
		stmt.setString(7, codProdotto);
		stmt.executeUpdate();
	}
}