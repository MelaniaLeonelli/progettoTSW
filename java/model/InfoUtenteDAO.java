package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.DriverManagerConnectionPool;

public class InfoUtenteDAO {
	
	public static String URL = "jdbc:mysql://localhost:3306/gamemoving";
	public static String USER = "sisi";
	public static String PASS = "password";
	
	public void insertData(String cf, String address, String city, String CAP, String phone, int points) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement stmt;
		stmt = con.prepareStatement("INSERT INTO infoutente VALUES (?, ?, ?, ?, ?, '0')");
		stmt.setString(1, cf);
		stmt.setString(2, address);
		stmt.setString(3, city);
		stmt.setString(4, CAP);
		stmt.setString(5, phone);
		stmt.executeUpdate();
	}
	
}
