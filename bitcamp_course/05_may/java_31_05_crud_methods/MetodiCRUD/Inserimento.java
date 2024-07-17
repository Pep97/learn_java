package java_31_05.MetodiCRUD;

import java.sql.*;

public class Inserimento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// connessione al database
		// definizione dei parametri necessari
		String url = "jdbc:mysql://localhost:3306/scuola";  // indirizzo TCP or HTTPS 
		// il nostro server risponde tramite il driver JDBC
		// dopo i due punti vengono specificato il dialetto, in questo caso mysql e i suoi comandi.
		// dove dobbiamo utilizzarlo? -> localhost (perché nel file di Bitcamp in workbrench come hostname: hai inserito "localhost")
		// 3306 -> si specifica il port del server
		// poi nome del database al quale ti vuoi connettere
		
		String username = "root";
		String password = "localbombcomputer";
		
		// accesso ed autorizzazione nel DB
		try {
			// blocco di codice da eseguire 
			
			Connection conn = DriverManager.getConnection(url, username, password); // chiami la libreria "Connection" e crei l'istanza con "conn"
			// getConnection(); -> metodo per creare la connession
			// driverManger -> class is to keep track of the drivers that are available, handle establishing a connection between a database and the appropriate driver, and handle things like login timeouts.
			
			System.out.println("Connessione al database avvenuta con successo");
			
			// query per l'inserimento dei dati
			// definire gli attributi
			
			String nomeNuovoStudente = "Anna";
			String cognomeNuovoStudente = "Bianchi";
			int etaNuovoStudente = 25;
			
			// creazione della query di inserimento
			
			String sqlInserimento = "INSERT INTO studenti(nome,cognome,eta)VALUES(?,?,?)";
					// non puoi mettere dei valori definiti, ma devi mettere dei placeholder
					// non cessesita del ";" finale all'interno del testo di SQL
			
			
			// libreria per passare query parametrizzate (che hanno dei valori) -> PreparedStatement
			// per query senza parametri -> statement
			
			PreparedStatement pstmtInserimento = conn.prepareStatement(sqlInserimento); // istanza della libreria -> di solito viene chiamata solo "pstmt"
			//prepareStatement() e un metodo della libreria conn
			
			// valorizzare i placeholder
			pstmtInserimento.setString(1, nomeNuovoStudente); // setString( che valore vuoi valorizzare? , come lo vuoi modificare? )
			pstmtInserimento.setString(2, cognomeNuovoStudente);
			pstmtInserimento.setInt(3, etaNuovoStudente);
			
			// esecuzione della query
			
			pstmtInserimento.executeUpdate(); // in caso di errore ti scatterá nel catch
			System.out.println("Record inserito con successo!");
			
			
			
			
			// bisogna chiudere la connessione. -> dal momento ti connetti te crei una connessione, se chiudi il programma senza chiudere il canale, il canale rimane aperto
			// ed accedere con facilitá al DB perché te hai giá validato che quella connessione é valida con l'username e password.
			
			
			// chiudere la connessione
			
			// chiudi tutte le librerie
			pstmtInserimento.close();
			conn.close();
			
			// i server SQL permette l'accesso diretto al hardware e di conseguenza l'accesso ad ogni file sulla macchina.
			
			
			
			
		} catch (SQLException e) {  // con la "e" te stai creando l'istanza della libreria
			// blocco di codice per gestire l'eccezione
			// per ogni errore c'é una libreria ad hock. -> hai un problema con la date, stringhe, numeri, etc..? c'é una libraria specifica.
			
			System.out.println("Errore nella connessione nel database");
			e.printStackTrace(); // in questo modo vedi tutto l'errore tecnico e l'utente finale non lo visualizza.
		}
		

		
		
		
		
		

	}

}


