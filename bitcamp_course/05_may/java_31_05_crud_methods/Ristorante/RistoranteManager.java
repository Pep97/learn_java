package java_31_05.Ristorante;


import java.sql.*;
import java.util.Scanner;

public class RistoranteManager {
    
	
	// definizione degli attributi del progetto
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ristorante";	// final -> una volta inseriti non posssono essere cambiati
	// puoi usare url o DB_URL
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "localbombcomputer";
	
	// definizione delle query SQL
	private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS menu("+
				"id INT AUTO_INCREMENT PRIMARY KEY,"+
				"nome VARCHAR(100) NOT NULL," +
				"prezzo DOUBLE NOT NULL"+
				")";
	private static final String INSERT_QUERY = "INSERT INTO menu (nome, prezzo) VALUES (? , ?)";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM menu";
	private static final String UPDATE_QUERY = "UPDATE menu SET nome = ?, prezzo = ? WHERE id = ?";
	private static final String DELETE_QUERY = "DELETE FROM menu WHERE id = ?";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// richiamo un metodo per inizializzare la tabella se non pre esistente
		createTableIfNotExists();
		
		// istanza
		
		Scanner scanner = new Scanner(System.in);
		
		// attributi
		
		int scelta = -1;
		
		// ciclo principale del menu
		while(scelta != 0) {
			System.out.println("Seleziona un'operazione");
			System.out.println("1. Aggiungi un piatto al menu");
			System.out.println("2. Visualizza il menu");
			System.out.println("3. Modifica un piatto");
			System.out.println("4. Elimina un piatto");
			System.out.println("0. Esci");
			
			scelta = scanner.nextInt();
			scanner.nextLine();
			
			switch(scelta) {
			case 1:
				System.out.println("Inserisci il nome del piatto:");
				String nome = scanner.nextLine();
				System.out.println("Inserisci il prezzo del piatto:");
				double prezzo = scanner.nextDouble();
				// chiamata della funzione per l'inserimento di un nuovo piatto
				
				insertPiatto(nome, prezzo);
				System.out.println("Piatto aggiunto al menu.");
				break;
			case 2:
				System.out.println("Menu:");
				// chiamata della funzione per la stampa dei record presenti nella tabella menu
				printMenu();

				break;
			case 3:
				System.out.println("Inserisci l'ID del piatto da modificare:");
				int idModifica = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Inserisci il nuovo nome del piatto:");
				String nuovoNome = scanner.nextLine();

				System.out.println("Inserisci il nuovo prezzo del piatto:");
				double nuovoPrezzo = scanner.nextDouble();
				// chiamata della funzione per aggiornare il menu
				updatePiatto(idModifica, nuovoNome, nuovoPrezzo);
				
				System.out.println("Piatto modificato.");
				
				break;
			case 4:
				
				System.out.println("Inserisci l'ID del piatto da eliminare:");
				int idElimina = scanner.nextInt();
				scanner.nextLine();
				
				deletePiatto(idElimina);
				System.out.println("Piatto eliminato.");

				break;
			case 0:
				System.out.println("Arrivederci!");
				break;
			default:
				System.out.println("Scelta non valida!");

			}
			
			
		}
		
		scanner.close();


		
	}
	
	
	// metodo creazione tabella menu
	private static void createTableIfNotExists() {
		// connessione al DB
		
		try (
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// gestione query
			Statement stmt = conn.createStatement();
			// non é detto che il nostro DB si trova in una rete locale
			// si potrebbe trovare a distanza e creare dei lag.
			// se il database non riceve la tua richiesta entro tot tempo potrebbe chiudere la richiesta
			// mettondo le librerie come parametro crei un pre-controllo che ti crea la connessione solo quando la query all'interno del codice scatta
			
			){
			
				stmt.executeUpdate(CREATE_TABLE_QUERY);
				
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
	}
	
	// metodo per inserire un piatto nella tabella menu
	private static void insertPiatto(String nome , double prezzo) {
		// connessione al DB
		
		try (
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY)
			){
			
			// valorizzazione dei placeholder
			pstmt.setString(1, nome);
			pstmt.setDouble(2, prezzo);
			
			// esecuzione della query
			
			pstmt.executeUpdate();
			
				
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}

	// metodo per visualizzare il menu completo
	private static void printMenu() {
		// connessione al DB
		
		try (
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
			){
			
			// estraiamo i singoli campi del record trattato all'interno di variabili
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				double prezzo = rs.getDouble("prezzo");
				
				System.out.println("ID: " + id + ", Nome Piatto: " + nome + ", Prezzo: " + prezzo + " euro." );
			}
			
			
				
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	// metodo per modificare un piatto
	private static void updatePiatto(int id, String nome, double prezzo) {
		
		try (
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY);
			){
			
			// valorizzare i placeholder
			
			pstmt.setString(1, nome);
			pstmt.setDouble(2, prezzo);
			pstmt.setInt(3, id);
			
			// esecuzione query
			pstmt.executeUpdate();
			
				
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	// metodo per eliminare un piatto
	private static void deletePiatto(int id) {
		
		try (
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY);
			){
			
			// valorizzare i placeholder

			pstmt.setInt(1, id);
			
			// esecuzione query
			pstmt.executeUpdate();
			
				
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	/* IMPORTANTE
	 in ognuno di questi metodi dovresti fare la chiusura delle librerie utilizzate
	 */
	
	
	
	
	
	
}
