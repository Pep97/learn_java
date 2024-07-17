package java_31_05.MetodiCRUD;

import java.sql.*;

public class Visualizzazione {

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
			
			// esecuzione query di estrazione dati
			
			Statement stmtVisualizzazione = conn.createStatement();// di solito si chiama "stmt"
			
			// libreria per contenere e gestire i record estratti
			
			ResultSet rsVisualizzazione = stmtVisualizzazione.executeQuery("SELECT * FROM studenti");// istanza della libraria, di solito si chiama "rs"
			// ResultSet -> libreria che organizza tutti i record
			
			// iterazione sul ResultSet
			while(rsVisualizzazione.next()) { // next() -> ci torna true finché ci sono altri elementi e false quando dopo l'ultimo elemento non ci sono altri elementi
			
				int id = rsVisualizzazione.getInt("id"); // la PK si chiama "id".
				String nome = rsVisualizzazione.getString("nome");
				String cognome = rsVisualizzazione.getString("cognome");
				int eta = rsVisualizzazione.getInt("eta");
				
				// stampa del contenuto della tabella studenti
				
				System.out.println("ID: " + id + " - Nome: " + nome + " ,Cognome: " + cognome + " ,eta: " + eta);

			}
			
			// chiusura delle connessioni ->  si chiudono all'incontrario, dall'ultima libreria istanziata fino alla prima
			
			rsVisualizzazione.close();
			stmtVisualizzazione.close();
			conn.close();
			
		} catch(SQLException e) {
			System.out.println("Errore durante la connessione al database");
			e.printStackTrace(); 
		}
		

	}

}

