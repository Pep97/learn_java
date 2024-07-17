package java_31_05.MetodiCRUD;

import java.sql.*;

public class Eliminazione {

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
			
			// definizione dello studente da eliminare 
			
			int idStudenteDaEliminare = 2;
			
			// creazione della query
			
			String sqlEliminazione = "DELETE FROM studenti WHERE id = ?";
			
			// istanza di PreparedStatement
			
			PreparedStatement pstmtEliminazione = conn.prepareStatement(sqlEliminazione);
			
			
			// valorizzazione placeholder
			
			pstmtEliminazione.setInt(1, idStudenteDaEliminare);
			
			// esecuzione della query
			
			int righeEliminate = pstmtEliminazione.executeUpdate(); // se viene eseguito ed elimina un valore -> righeEliminate = 1
			
			// controllo se il record eliminato é effettivamento eliminato, e se seleziono un indice non esiste dico all'utente che quel valore non esiste
			// controllo effettivo dei records
			
			if(righeEliminate > 0) {
				System.out.println("Record eliminato con successo");
			} else {
				System.out.println("Nessun record eliminato");
			}
			
			pstmtEliminazione.close();
			conn.close();
			
			
		} catch(SQLException e) {
			System.out.println("Errore durante la connessione al database");
			e.printStackTrace(); 
		}
		
		
		
		
	}

}

