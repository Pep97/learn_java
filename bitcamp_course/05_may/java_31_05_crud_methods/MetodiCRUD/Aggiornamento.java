package java_31_05.MetodiCRUD;

import java.sql.*;

public class Aggiornamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// connessione al database
		
		String url = "jdbc:mysql://localhost:3306/scuola";	
		String username = "root";
		String password = "localbombcomputer";
		
		// blocco try catch
		
		try {
			//autorizzazione al database
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connessione al database avvenuta con successo!");
			
			// aggiornamento dei dati per la modifica
			
			int idStudenteDaAggiornare = 2;
			String nuovoNome = "Luigi";
			String nuovoCognome = "Giallo";
			int nuovaEta = 18;
			
			// query per l'update
			String sqlAggiornamento = "UPDATE studenti SET nome = ?, cognome = ?, eta = ? WHERE id = ?";
			
			// si richiama PreparedStatement per inviare la query al server
			
			PreparedStatement pstmtAggiornamento = conn.prepareStatement(sqlAggiornamento);
			
			// valorizzare i placeholder
			
			pstmtAggiornamento.setString(1, nuovoNome);
			pstmtAggiornamento.setString(2, nuovoCognome);
			pstmtAggiornamento.setInt(3, nuovaEta);
			pstmtAggiornamento.setInt(4, idStudenteDaAggiornare);

			// esecuzione della query
			
			pstmtAggiornamento.executeUpdate();
			
			// feedback utente
			
			System.out.println("Record aggiornato con successo!");
			
			// chiusura connessioni
			
			pstmtAggiornamento.close();
			conn.close();
			
			
			
			
			
		} catch(SQLException e) {
			System.out.println("Errore durante la connessione al database");
			e.printStackTrace(); 
		}
		
		
		
	}

}


