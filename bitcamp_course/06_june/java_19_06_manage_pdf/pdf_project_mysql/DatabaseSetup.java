package java_19_06.pdf_project_mysql;

import java.sql.*;

public class DatabaseSetup {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "localbombcomputer";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS FattureDatabase");
			stmt.executeUpdate("USE fattureDatabase");
			
			String createTableSQL = "CREATE TABLE IF NOT EXISTS Fatture ("
								  + "ID INT AUTO_INCREMENT PRIMARY KEY, "
							  	  + "Descrizione VARCHAR(255),"
								  + "Quantita int,"
								  + "Prezzo Decimal(10,2))";
			stmt.executeUpdate(createTableSQL);
			
			String insertDataSQL = "INSERT INTO Fatture (Descrizione, Quantita, Prezzo) VALUES "
								 + "('Articolo 1', 2, 50.00),"
								 + "('Articolo 2', 1, 75.00)";
			
			stmt.executeUpdate(insertDataSQL);
			
			System.out.println("Database e dati avvenuti con successo!");
			stmt.close();
			conn.close();


			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
